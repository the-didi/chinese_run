<template>
	<a-card class="activity-container">
		<!-- 库区查询模块开始 -->
		<div class="data-form">
			<a-form name="reservoir_controllers" layout="inline" :model="reservoirController" @finish="onFinish">
				<a-form-item name="reservoirCode" label="库区编码">
					<a-input v-model:value="reservoirController.rsCode" allow-clear placeholder="输入库区编码查询" />
				</a-form-item>
				<a-form-item name="reservoirName" label="库区名称">
					<a-input v-model:value="reservoirController.rsName" allow-clear placeholder="输入库区名称查询" />
				</a-form-item>
				<a-form-item name="reservoirDesc" label="库区备注">
					<a-input v-model:value="reservoirController.rsDesc" allow-clear placeholder="输入库区备注查询" />
				</a-form-item>
				<a-form-item name="reservoirDesc" label="库区属性">
					<a-select v-model:value="reservoirController.rsType" allow-clear placeholder="请选择库区属性" style="width:180px">
						<a-select-option :value="0">公有</a-select-option>
						<a-select-option :value="1">私有</a-select-option>
					</a-select>
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
		<!-- 库区查询模块结束 -->
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
			<vxe-column field="tenantNo" title="货主"></vxe-column>
			<vxe-column field="username" show-overflow title="货主名称"></vxe-column>
			<vxe-column field="rsCode" title="库区编码"></vxe-column>
			<vxe-column field="rsName" title="库区名称"></vxe-column>
			<vxe-column field="rsDesc" title="库区备注"></vxe-column>
			<vxe-column field="rsType" title="库区类型"></vxe-column>
			<vxe-column width="200px" title="操作">
				<template #default="{ row }">
					<a-button type="link" @click="handleEdit(row)">编辑</a-button>
					<a-dropdown>
						<template #overlay>
							<a-menu @click="handleMenuClick">
								<a-menu-item key="1">管理储区</a-menu-item>
								<a-menu-item key="2">物料转移</a-menu-item>
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
        <!-- 分页模块开始 -->
        <vxe-pager
			background
			v-model:current-page="reservoirController.current"
			v-model:page-size="reservoirController.size"
			:total="reservoirController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
        <!-- 分页模块结束 -->
	</a-card>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs,ref, onMounted } from 'vue';
import { Icon } from '/@/utils/antdIcon';
import { VxeTableInstance, VxeTableEvents, VxePagerEvents } from 'vxe-table';
import { message } from 'ant-design-vue';
export default defineComponent({
    components:{
        Icon
    },
	setup() {
        const mainTable = ref({} as VxeTableInstance);
		const state = reactive({
			reservoirController: {
				rsName: '',
				rsDesc: '',
				rsCode: '',
                current:1,
                size:10,
                totalResult:0
			},
            dataSource: [],
            loading:false,
            selectedRowKeys:[]
		});
        onMounted(()=>{
            loadData()
        })
        const handleAdd=()=>{

        }
        const loadData=()=>{

        }
        const handleBatchDelete=()=>{

        }
		const onFinish = () => {};
        const onClearSelected=()=>{

        }
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
        const handleEdit=()=>{

        }
        const handleMenuClick=()=>{

        }
        const handlePageChange: VxePagerEvents.PageChange = ({ currentPage, pageSize }) => {
			state.reservoirController.current = currentPage;
			state.reservoirController.size = pageSize;
			loadData();
		};
		return {
			...toRefs(state),
            handleAdd,
            handleBatchDelete,
            handleEdit,
            selectChangeEvent1,
            selectAllChangeEvent1,
            handleMenuClick,
            mainTable,
            onClearSelected,
            handlePageChange,
			onFinish,
            loadData
		};
	},
});
</script>
