<template>
    <a-card class="activity-container">
        <!-- 控制查询模块开始 -->
        <div class="data-form">
			<a-form name="user_controllers" layout="inline" :model="userController" @finish="onFinish">
				<a-form-item name="menuName" label="用户账号">
					<a-input v-model:value="userController.username" allow-clear placeholder="输入用户账号查询" />
				</a-form-item>
                <a-form-item name="menuName" label="用户姓名">
					<a-input v-model:value="userController.fullname" allow-clear placeholder="请输入用户姓名"></a-input>
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
        <!-- 控制查询模块结束 -->
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
			<vxe-column field="username" title="用户账号"></vxe-column>
            <vxe-column field="mobile" show-overflow title="手机号"></vxe-column>
			<vxe-column field="email" show-overflow title="邮箱"></vxe-column>
			<vxe-column field="status" title="状态"></vxe-column>
			<vxe-column field="createBy" show-overflow title="创建人"></vxe-column>
			<vxe-column field="modifyBy" show-overflow title="修改人"></vxe-column>
			<vxe-column field="created" show-overflow title="创建时间"></vxe-column>
			<vxe-column field="lastUpdateTime" show-overflow title="修改时间"></vxe-column>
			<vxe-column width="150px" title="操作">
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
			v-model:current-page="userController.currentPage"
			v-model:page-size="userController.pageSize"
			:total="userController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
        <!-- 分页模块结束 -->
    </a-card>
</template>
<script lang="ts">
import { defineComponent, reactive,toRefs,ref, onMounted } from 'vue'
import { VxeTableInstance, VxeTableEvents,VxePagerEvents  } from 'vxe-table'
import { Icon } from '/@/utils/antdIcon';
import {findByPage} from '/@/api/system/user'
export default defineComponent({
    components: {
        Icon
    },
    setup() {
        const mainTable = ref({} as VxeTableInstance)
        const state=reactive({
            userController:{
                current: 1,
                size:10,
                totalResult: 0
            },
            dataSource: [],
            loading: false,
            selectedRowKeys: []
        })
        onMounted(()=>{
            loadData()
        })
        const loadData=()=>{
            state.loading=true
            findByPage(state.userController).then(res=>{
                state.dataSource=res.data.records
                state.userController.current=res.data.current
                state.userController.size=res.data.size
                state.userController.totalResult=res.data.total
            }).finally(()=>{
                state.loading=false
            })
        }   
        // 查询表单提交事件
        const onFinish=()=>{

        }
        // 控制新增按钮点击事件
        const handleAdd=()=>{

        }
        // 控制批量删除事件
        const handleBatchDelete=()=>{

        }
        // 控制分页切换
        const handlePageChange:VxePagerEvents.PageChange = ({ currentPage, pageSize })=>{
			state.userController.current=currentPage
			state.userController.size=pageSize
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
        const handleEdit=(row:unknown)=>{

        }
        const handleDel=(row:unknown)=>{

        }
        return {
            ...toRefs(state),
            onFinish,
            handleBatchDelete,
            handlePageChange,
            handleEdit,
            handleDel,
            selectAllChangeEvent1,
            mainTable,
            selectChangeEvent1,
            handleAdd
        }
    },
})
</script>
<style scoped>

</style>
