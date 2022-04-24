
<template>
	<a-card hoverable class="activity-container">
		<!-- 表格查询部分开始 -->
		<div class="data-form">
			<a-form name="menu_controllers" layout="inline" :model="menuController" @finish="onFinish">
				<a-form-item name="menuName" label="菜单名称">
					<a-input v-model:value="menuController.menuName" allow-clear placeholder="输入菜单名称查询" />
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
		</div>
		<!-- 按钮组模块结束 -->
		<!-- 数据表格模块开始 -->
		<div class="ant-alert ant-alert-info" style="margin-bottom: 16px">
			<Icon icon="SettingOutlined" />
			<span style="margin-left:5px"
				>已选择&nbsp;<a style="font-weight: 600;">{{ selectedRowKeys.length }}</a
				>项&nbsp;&nbsp;</span
			>
			<a style="margin-left: 24px" @click="onClearSelected">清空</a>
		</div>
        <vxe-table
          :row-config="{keyField: 'id'}"
          :column-config="{resizable: true}"

          :data="dataSource">
          <vxe-column field="name" title="菜单名称"></vxe-column>
          <vxe-column field="desc" title="菜单描述"></vxe-column>
          <vxe-column field="status" title="状态"></vxe-column>
          <vxe-column field="createBy" title="创建人"></vxe-column>
          <vxe-column field="modifyBy" title="修改人"></vxe-column>
          <vxe-column field="created" title="创建时间"></vxe-column>
          <vxe-column field="lastUpdateTime" title="修改时间"></vxe-column>
        </vxe-table>
		<!-- 数据表格模块结束 -->
	</a-card>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue';
import { Icon } from '/@/utils/antdIcon';
export default defineComponent({
	components: {
		Icon,
	},
	setup() {
		const state = reactive({
			menuController: {},
			selectedRowKeys: [],
            dataSource: []
		});
		const onFinish = (values: any) => {
			console.log(values);
		};
		const handleAdd = () => {
			console.log('新增菜单项');
		};
		const onClearSelected = () => {};
		return {
			onFinish,
			handleAdd,
			onClearSelected,
			...toRefs(state),
		};
	},
});
</script>

