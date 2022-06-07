
<template>
	<a-card class="activity-container">
		<!-- 表格查询部分开始 -->
		<div class="data-form">
			<a-form name="menu_controllers" layout="inline" :model="menuController" @finish="onFinish">
				<a-form-item name="menuName" label="菜单名称">
					<a-input v-model:value="menuController.name" allow-clear placeholder="输入菜单名称查询" />
				</a-form-item>
				<a-form-item>
					<a-button type="primary" html-type="submit">
						<template #icon>
							<Icon icon="SearchOutlined" />
						</template>
						查询
					</a-button>
				</a-form-item>
			</a-form>
		</div>
		<!-- 表格查询部分结束 -->
		<!-- 按钮组模块开始 -->
		<div class="btn-group">
			<a-button type="primary" @click="handleAdd">
				<template #icon>
					<Icon icon="PlusOutlined" />
				</template>
				新增
			</a-button>
			<a-button type="primary" style="margin-left: 5px" v-if="selectedRowKeys.length != 0" @click="handleBatchDelete">
				<template #icon>
					<Icon icon="DeleteOutlined" />
				</template>
				批量删除
			</a-button>
		</div>
		<!-- 按钮组模块结束 -->
		<!-- 数据表格模块开始 -->
		<div class="ant-alert ant-alert-info" style="margin-bottom: 16px">
			<Icon icon="SettingOutlined" />
			<span style="margin-left: 5px"
				>已选择&nbsp;<a style="font-weight: 600">{{ selectedRowKeys.length }}</a
				>项&nbsp;&nbsp;</span
			>
			<a style="margin-left: 24px" @click="onClearSelected">清空</a>
		</div>
		<vxe-table
			border
			ref="mainTable"
			:row-config="{ keyField: 'id' }"
			:column-config="{ resizable: true }"
			align="center"
			height="500"
			:loading="loading"
			:data="dataSource"
			@checkbox-all="selectAllChangeEvent1"
			@checkbox-change="selectChangeEvent1"
		>
			<vxe-column type="seq" width="60" title="#"></vxe-column>
			<vxe-column type="checkbox" width="60"></vxe-column>
			<vxe-column field="name" title="菜单名称"></vxe-column>
			<vxe-column field="desc" show-overflow title="菜单描述"></vxe-column>
			<vxe-column field="status" title="状态">
				<template #default="{row}">
					<a-switch 
						v-model:checked="row.status" 
						checked-children="启用" 
						:checked-value="1" 
						:unchecked-value="0" 
						un-checked-children="禁用" />
				</template>
			</vxe-column>
			<vxe-column field="createBy" title="创建人"></vxe-column>
			<vxe-column field="modifyBy" title="修改人"></vxe-column>
			<vxe-column field="created" title="创建时间"></vxe-column>
			<vxe-column field="lastUpdateTime" title="修改时间"></vxe-column>
			<vxe-column width="200px" title="操作">
				<template #default="{ row }">
					<a-button type="link" @click="handleEdit(row)">编辑</a-button>
					<a-button type="link" @click="handlePrivilege(row)">赋能</a-button>
					<a-button type="link" @click="handleDel(row)">删除</a-button>
				</template>
			</vxe-column>
		</vxe-table>
		<!-- 数据表格模块结束 -->
		<!-- 分页模块开始 -->
		<vxe-pager
			background
			v-model:current-page="menuController.current"
			v-model:page-size="menuController.size"
			:total="menuController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
		<!-- 分页模块结束 -->
		<!-- 弹窗模块开始 -->
		<!-- 添加弹窗开始 -->
		<a-modal v-model:visible="addMenuVisible" title="新增菜单" cancelText="取消" okText="确定" @ok="handleAddOk">
			<a-form name="menu_add_controllers" :model="menuAddController" @finish="onAddFinish">
				<a-form-item name="menuName" label="菜单名称">
					<a-input v-model:value="menuAddController.name" allow-clear placeholder="输入菜单名称" />
				</a-form-item>
				<a-form-item name="menuDesc" label="菜单描述">
					<a-textarea v-model:value="menuAddController.desc" allow-clear placeholder="输入菜单描述" />
				</a-form-item>
				<a-form-item name="menuType" label="菜单描述">
					<a-select ref="select" v-model:value="menuAddController.type" placeholder="请选择父菜单,不选择为父菜单" style="width: 100%">
						<a-select-option v-for="(item, index) in parentList" :key="index" :value="item.id">{{ item.name }}</a-select-option>
					</a-select>
				</a-form-item>
				<a-form-item name="menuIcon" label="菜单图标">
					<a-input v-model:value="menuAddController.menuIcon" allow-clear placeholder="输入菜单图标" />
				</a-form-item>
				<a-form-item name="menuUrl" label="菜单指向路径">
					<a-input type="text" placeholder="请输入菜单指向路径" v-model:value="menuAddController.targetUrl"></a-input>
				</a-form-item>
				<a-form-item name="menuStatus" label="菜单状态">
					<a-switch
						v-model:checked="menuAddController.status"
						:checkedValue="1"
						checked-children="启动"
						un-checked-children="禁用"
						:uncheckedValue="0"
					/>
				</a-form-item>
			</a-form>
		</a-modal>
		<!-- 添加弹窗结束 -->
		<!-- 编辑弹窗开始 -->
		<!-- 此处按照正常逻辑来说要提出来一个组件 不过我懒了 -->
		<a-modal v-model:visible="editMenuVisible" title="新增菜单" cancelText="取消" okText="确定" @ok="handleEditOk">
			<a-form name="menu_add_controllers" :model="menuEditController" @finish="onAddFinish">
				<a-form-item name="menuName" label="菜单名称">
					<a-input v-model:value="menuEditController.name" allow-clear placeholder="输入菜单名称查询" />
				</a-form-item>
				<a-form-item name="menuDesc" label="菜单描述">
					<a-textarea v-model:value="menuEditController.desc" allow-clear placeholder="输入菜单描述" />
				</a-form-item>
				<a-form-item name="menuType" label="父菜单">
					<a-select ref="select" v-model:value="menuEditController.type" placeholder="请选择父菜单,不选择为父菜单" style="width: 100%">
						<a-select-option v-for="(item, index) in parentList" :key="index" :value="item.id">{{ item.name }}</a-select-option>
					</a-select>
				</a-form-item>
				<a-form-item name="menuIcon" label="菜单图标">
					<a-input v-model:value="menuEditController.menuIcon" allow-clear placeholder="输入菜单图标" />
				</a-form-item>
				<a-form-item name="menuUrl" label="菜单指向路径">
					<a-input type="text" placeholder="请输入菜单指向路径" allow-clear v-model:value="menuEditController.targetUrl"></a-input>
				</a-form-item>
				<a-form-item name="menuStatus" label="菜单状态">
					<a-switch
						v-model:checked="menuEditController.status"
						:checkedValue="1"
						checked-children="启动"
						un-checked-children="禁用"
						:uncheckedValue="0"
					/>
				</a-form-item>
			</a-form>
		</a-modal>
		<!-- 编辑弹窗结束 -->
		<!-- 弹窗模块结束 -->
		
	</a-card>
</template>
<script lang="ts">
import { defineComponent, onMounted, ref, reactive, toRefs } from 'vue';
import { Icon } from '/@/utils/antdIcon';
import { findByPage, deleteByIds, deleteMenuById, getMenuById, addMenu,updateMenu } from '/@/api/system/menu';
import { VxeTableInstance, VxeTableEvents, VxePagerEvents } from 'vxe-table';
import { message } from 'ant-design-vue';
import { Session } from '/@/utils/storage';
export default defineComponent({
	components: {
		Icon,
	},
	setup() {
		const mainTable = ref({} as VxeTableInstance);
		const state = reactive({
			menuController: {
				current: 1,
				size: 10,
				totalResult: 0,
				name: '',
			},
			menuAddController: {},
			menuEditController: {},
			editMenuVisible: false,
			addMenuVisible: false,
			loading: false,
			selectedRowKeys: [],
			dataSource: [],
			parentList: Session.get('ParentList'),
		});
		onMounted(() => {
			loadData();
		});
		const onFinish = (values: any) => {
			loadData();
		};
		const handleAdd = () => {
			state.addMenuVisible = true;
			console.log('新增菜单项');
		};
		// 加载数据
		const loadData = () => {
			// 表格开始加载
			state.loading = true;
			// 请求后台
			findByPage(state.menuController)
				.then((res) => {
					// 答应结果
					console.log(res);
					state.dataSource = res.data.records;
					state.menuController.current = res.data.current;
					state.menuController.totalResult = res.data.total;
					state.menuController.size = res.data.pageSize;
				})
				.finally(() => {
					state.loading = false;
				});
		};
		const handleEdit = (row: any) => {
			getMenuById({ id: row.id })
				.then((res) => {
					state.menuEditController = res.data;
				})
				.finally(() => {
					state.editMenuVisible = true;
				});
		};
		const handleDel = (row: any) => {
			state.loading = true;
			deleteMenuById(row.id)
				.then((res) => {
					message.success(res.data);
				})
				.finally(() => {
					state.loading = false;
				});
			console.log(row);
		};
		// 设置表格全选
		const selectAllChangeEvent1: VxeTableEvents.CheckboxAll = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
			console.log(state.selectedRowKeys);
		};
		// 设置表格选择事件
		const selectChangeEvent1: VxeTableEvents.CheckboxChange = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
		};
		// 设置表格清空
		const onClearSelected = () => {
			const $table = mainTable.value;
			$table.clearCheckboxRow();
			state.selectedRowKeys = [];
		};
		// 设置分页切换重新赋值
		const handlePageChange: VxePagerEvents.PageChange = ({ currentPage, pageSize }) => {
			state.menuController.current = currentPage;
			state.menuController.size = pageSize;
			loadData();
		};
		// 设置批量删除
		const handleBatchDelete = () => {
			deleteByIds(
				state.selectedRowKeys.map((e) => {
					return e.id;
				})
			).then((res) => {
				console.log(res);
				message.success(res.data);
				state.selectedRowKeys = [];
				loadData();
			});
		};
		// 设置新增打开弹窗
		const handleAddOk = () => {
			addMenu(state.menuAddController)
				.then((res) => {
					message.success(res.data);
				})
				.finally(() => {
					state.addMenuVisible = false;
					state.menuAddController={}
					loadData();
				});
		};
		// 设置新增弹窗之后执行网络事件
		const onAddFinish = () => {};
		// 设置编辑菜单之后执行的网格事件
		const handleEditOk = () => {
			updateMenu(state.menuEditController).then(res=>{
				message.success(res.data);
			}).finally(()=>{
				state.editMenuVisible = false;
				state.menuEditController={}
				loadData()
			})
			
		};
		const handlePrivilege = () => {};
		return {
			onFinish,
			handleAdd,
			selectAllChangeEvent1,
			selectChangeEvent1,
			onAddFinish,
			handleEdit,
			handleAddOk,
			mainTable,
			handleDel,
			handlePrivilege,
			onClearSelected,
			handleBatchDelete,
			handleEditOk,
			handlePageChange,
			...toRefs(state),
		};
	},
});
</script>

