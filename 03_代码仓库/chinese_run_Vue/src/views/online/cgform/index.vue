<template>
	<a-card class="activity-container">
		<!-- 表格查询部分开始 -->
		<div class="data-form">
			<a-form name="cgform_controllers" layout="inline" :model="cgformController" @finish="onFinish">
				<a-form-item name="cgformName" label="报表名称">
					<a-input v-model:value="cgformController.tableName" allow-clear placeholder="输入报表名称查询" />
				</a-form-item>
				<a-form-item name="cgformComment" label="报表描述">
					<a-input v-model:value="cgformController.tableComment" allow-clear placeholder="输入报表描述查询" />
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
		<!-- 表格查询模块结束 -->
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
			<a-button type="primary" style="margin-left: 5px" @click="handleImportTable">
				<template #icon>
					<Icon icon="ConsoleSqlOutlined" />
				</template>
				导入数据库表
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
			<vxe-column field="tableName" title="表名"></vxe-column>
			<vxe-column field="tableComment" show-overflow title="表描述"></vxe-column>
			<vxe-column field="tableSchema" title="数据源"></vxe-column>
			<vxe-column field="engine" title="引擎"></vxe-column>
			<vxe-column field="createTime" title="创建时间"></vxe-column>
			<vxe-column field="updateTime" title="修改时间"></vxe-column>
			<vxe-column width="200px" title="操作">
				<template #default="{ row }">
					<a-button type="link" @click="handleEdit(row)">编辑</a-button>
					<a-dropdown>
						<template #overlay>
							<a-menu @click="handleMenuClick">
								<a-menu-item key="1">代码生成</a-menu-item>
								<a-menu-item key="2">角色控制</a-menu-item>
								<a-menu-item key="3">权限授权</a-menu-item>
							</a-menu>
						</template>
						<a-button type="link">
							更多
							<Icon icon="DownOutlined" />
						</a-button>
					</a-dropdown>
				</template>
			</vxe-column>
		</vxe-table>
		<!-- 数据表格模块结束 -->
	</a-card>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs, ref, onMounted } from 'vue';
import { VxeTableInstance, VxeTableEvents, VxePagerEvents } from 'vxe-table';
import { Icon } from '/@/utils/antdIcon';
import { findByPage } from '/@/api/online/cgform';
export default defineComponent({
	components: {
		Icon,
	},
	setup() {
		const mainTable = ref({} as VxeTableInstance);
		const state = reactive({
			cgformController: {
				current: 1,
				size: 10,
				totalResult: 0,
				tableName: '',
				tableComment: '',
			},
			dataSource: [],
			loading: false,
			selectedRowKeys: [],
		});
		onMounted(() => {
			loadData();
		});
		const onFinish = () => {
			loadData();
		};
		const handleAdd = () => {};
		const handleBatchDelete = () => {};
		const handleImportTable = () => {};
		const onClearSelected = () => {};
		const handleEdit = (row: unknown) => {};
		const loadData = () => {
			state.loading = true;
			findByPage(state.cgformController)
				.then((res) => {
					console.log(res);
					state.dataSource = res.data.records;
				})
				.finally(() => {
					state.loading = false;
				});
		};
		return {
			mainTable,
			...toRefs(state),
			onClearSelected,
			handleAdd,
			handleImportTable,
			handleBatchDelete,
			handleEdit,
			onFinish,
		};
	},
});
</script>
<style scoped>
</style>
