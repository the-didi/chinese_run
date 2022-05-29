<template>
    <a-card class="activity-container">
        <!-- 查询部分开始 -->
        <div class="data-form">
			<a-form name="menu_controllers" layout="inline" :model="OtherController" @finish="onFinish">
				<a-form-item name="subscribeName" label="进货通知单号">
					<a-input v-model:value="OtherController.name" allow-clear placeholder="输入订单编号查询" />
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
        <!-- 查询部分结束 -->
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
            <vxe-column field="tzNo" title="进货通知单号"></vxe-column>
			<vxe-column field="arriveTime" title="预计到货时间"></vxe-column>
			<vxe-column field="carId" title="车牌号"></vxe-column>
			<vxe-column field="driverTel" title="司机电话号码"></vxe-column>
			<vxe-column field="order_category" title="货物种类"></vxe-column>
			<vxe-column field="createBy" show-overflow title="创建人"></vxe-column>
			<vxe-column field="modifyBy" title="修改人"></vxe-column>
			<vxe-column field="createTime" show-overflow title="创建时间"></vxe-column>
			<vxe-column field="lastUpdateTime" show-overflow title="修改时间"></vxe-column>
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
			v-model:current-page="OtherController.currentPage"
			v-model:page-size="OtherController.pageSize"
			:total="OtherController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
		<!-- 分页模块结束 -->
		<!-- 抽屉模块开始 -->
    </a-card>
</template>
<script lang="ts">
import { defineComponent,reactive,toRefs,ref, onMounted } from 'vue'
import { Icon } from '/@/utils/antdIcon';
import { VxeTableInstance, VxeTableEvents,VxePagerEvents  } from 'vxe-table'
import { findByPage } from '/@/api/system/Otherstorage';
export default defineComponent({
    components:{
        Icon
    },
    setup() {
        const mainTable = ref({} as VxeTableInstance)
        const state=reactive({
            OtherController:{
                name:"",
                currentPage: 1,
                pageSize: 10,
                totalResult: 0
            },
            dataSource:[],
            selectedRowKeys:[],
            loading:false,

        })
        // 在页面加载时执行加载数据函数
        onMounted(()=>{
            loadData()
        })
        // 提交查询表单
        const onFinish=()=>{

        }
        // 控制按钮得到点击执行事件
        const handleAdd=()=>{

        }
        // 批量删除
        const handleBatchDelete=()=>{

        }
        // 清空选中
        const onClearSelected=()=>{

        }
        // 点击编辑按钮执行事件
        const handleEdit=(row:any)=>{

        }
        // 控制删除按钮点击
        const handleDel=(row:any)=>{

        }
        // 控制加载数据
        const loadData=()=>{
            // 控制表格开始加载数据
            state.loading=true
            findByPage(state.OtherController).then(res=>{
                state.OtherController.currentPage=res.data.current
                state.OtherController.totalResult=res.data.total
                state.OtherController.pageSize=res.data.size
                state.dataSource=res.data.records
            }).finally(()=>{
                state.loading=false
            })
        }
        // 控制分页切换
        const handlePageChange:VxePagerEvents.PageChange = ({ currentPage, pageSize })=>{
			state.OtherController.currentPage=currentPage
			state.OtherController.pageSize=pageSize
			loadData()
		}
        // 控制全选
        const selectAllChangeEvent1: VxeTableEvents.CheckboxAll = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
			console.log(state.selectedRowKeys)
		};
        // 控制表格选择
		const selectChangeEvent1: VxeTableEvents.CheckboxChange = ({ checked }) => {
			const $table = mainTable.value;
			state.selectedRowKeys = $table.getCheckboxRecords();
		};
        return {
            ...toRefs(state),
            handleAdd,
            handleBatchDelete,
            onClearSelected,
            handleEdit,
            selectAllChangeEvent1,
            selectChangeEvent1,
            handleDel,
            handlePageChange,
            mainTable,
            onFinish
        }
    },
})
</script>

