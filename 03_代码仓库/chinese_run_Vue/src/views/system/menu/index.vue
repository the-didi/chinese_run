
<template>
	<a-card hoverable class="activity-container">
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
			<a-button type="primary" style="margin-left:5px" v-if="selectedRowKeys.length!=0" @click="handleBatchDelete">
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
			<vxe-column field="desc" title="菜单描述"></vxe-column>
			<vxe-column field="status" title="状态"></vxe-column>
			<vxe-column field="createBy" title="创建人"></vxe-column>
			<vxe-column field="modifyBy" title="修改人"></vxe-column>
			<vxe-column field="created" title="创建时间"></vxe-column>
			<vxe-column field="lastUpdateTime" title="修改时间"></vxe-column>
			<vxe-column title="操作">
				<template #default="{ row }">
					<a-button type="link" @click="handleEdit(row)">编辑</a-button>
					<a-button type="link" @click="handleDel(row)">删除</a-button>
				</template>
			</vxe-column>
		</vxe-table>
		<!-- 数据表格模块结束 -->
		<!-- 分页模块开始 -->
		<vxe-pager
			background
			v-model:current-page="menuController.currentPage"
			v-model:page-size="menuController.pageSize"
			:total="menuController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
		<!-- 分页模块结束 -->
		<!-- 弹窗模块开始 -->

		<!-- 弹窗模块结束 -->
	</a-card>
</template>
<script lang="ts">
import { defineComponent, onMounted, ref,reactive, toRefs } from 'vue';
import { Icon } from '/@/utils/antdIcon';
import { findByPage,deleteByIds } from '/@/api/system/menu';
import { VxeTableInstance, VxeTableEvents,VxePagerEvents  } from 'vxe-table'
import { message } from 'ant-design-vue';
export default defineComponent({
	components: {
		Icon,
	},
	setup() {
		const mainTable = ref({} as VxeTableInstance)
		const state = reactive({
			menuController: {
				currentPage: 1,
				pageSize: 10,
				totalResult: 0,
				name: '',
			},
			loading:false,
			selectedRowKeys: [],
			dataSource: [],
		});
		onMounted(() => {
			loadData();
		});
		const onFinish = (values: any) => {
			loadData()
		};
		const handleAdd = () => {
			console.log('新增菜单项');
		};
		const loadData = () => {
			state.loading=true
			findByPage(state.menuController).then((res) => {
				console.log(res)
				state.dataSource = res.data.records;
				state.menuController.currentPage = res.data.current;
				state.menuController.totalResult = res.data.total;
				state.menuController.pageSize = res.data.pageSize;
			}).finally(()=>{
				state.loading=false
			});
		};
		const handleEdit = (row: any) => {
			console.log(row);
		};
		const handleDel = (row: any) => {
			console.log(row);
		};
		const selectAllChangeEvent1: VxeTableEvents.CheckboxAll = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
			console.log(state.selectedRowKeys)
		};

		const selectChangeEvent1: VxeTableEvents.CheckboxChange = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
		};
		const onClearSelected = () => {
			const $table = mainTable.value;
			$table.clearCheckboxRow()
			state.selectedRowKeys=[]
		};
		const handlePageChange:VxePagerEvents.PageChange = ({ currentPage, pageSize })=>{
			state.menuController.currentPage=currentPage
			state.menuController.pageSize=pageSize
			loadData()
		}
		const handleBatchDelete=()=>{
			deleteByIds(state.selectedRowKeys.map(e=>{return e.id})).then(res=>{
				message.success(res.msg)
				loadData()
			})
		}
		return {
			onFinish,
			handleAdd,
			selectAllChangeEvent1,
			selectChangeEvent1,
			handleEdit,
			mainTable,
			handleDel,
			onClearSelected,
			handleBatchDelete,
			handlePageChange,
			...toRefs(state),
		};
	},
});
</script>

