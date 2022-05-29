<template>
    <a-card class="activity-container">
        <!-- 控制查询模块开始 -->
        <div class="data-form">
			<a-form name="driver_controllers" layout="inline" :model="driverAddController" @finish="onFinish">
                <a-form-item name="menuName" label="用户姓名">
					<a-input v-model:value="driverAddController.name" allow-clear placeholder="请输入用户姓名"></a-input>
				</a-form-item>
				<a-form-item>
					<a-button type="primary" html-type="submit" @click="search()">
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
			<vxe-column field="name" title="司机名称"></vxe-column>
            <vxe-column field="age" show-overflow title="年龄"></vxe-column>
            <vxe-column field="sex" show-overflow title="性别"></vxe-column>
            <vxe-column field="tel" show-overflow title="手机号"></vxe-column>
			<vxe-column field="carId" title="车牌号"></vxe-column>
			<vxe-column field="created" show-overflow title="创建时间"></vxe-column>
			<vxe-column field="lastUpdateTime" show-overflow title="修改时间"></vxe-column>
			<vxe-column field="orderId" show-overflow title="订单号"></vxe-column>
			<vxe-column width="250px" title="操作">
				<template #default="{ row }">
					<a-button type="link" @click="handleEdit(row)">编辑</a-button>
					<a-button type="link" @click="handleDel(row)">删除</a-button>
					<a-button type="link" @click="handle()">派订单</a-button>
				</template>
			</vxe-column>
		</vxe-table>
        <!-- 数据表格模块结束 -->
        <!-- 分页模块开始 -->
        <vxe-pager
			background
			v-model:current-page="driverController.current"
			v-model:page-size="driverController.size"
			:total="driverController.totalResult"
			@page-change="handlePageChange"
			:layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
		>
		</vxe-pager>
        <!-- 分页模块结束 -->
		<!-- 添加弹窗开始 -->
		<a-modal v-model:visible="editMenuVisible" title="修改司机信息" cancelText="取消" okText="确定" @ok="handleEditOk">
					<a-form name="driver_add_controllers" :model="driverEditController" @finish="onAddFinish">
				<a-form-item name="driverName" label="司机姓名">
					<a-input v-model:value="driverEditController.name" allow-clear />
				</a-form-item>
				<a-form-item name="driverAge" label="年龄">
					<a-input v-model:value="driverEditController.age" allow-clear />
				</a-form-item>
				<a-form-item name="driversex" label="司机性别">
					<a-input v-model:value="driverEditController.sex" allow-clear />
				</a-form-item>
				<a-form-item name="driverTel" label="手机号">
					<a-input v-model:value="driverEditController.tel" allow-clear />
				</a-form-item>
				<a-form-item name="driverCarId" label="车牌号">
					<a-input v-model:value="driverEditController.carId" allow-clear />
				</a-form-item>
				</a-form>
		</a-modal>
		<!-- 添加弹窗结束 -->
			<!-- 编辑弹窗开始 -->
		<!-- 此处按照正常逻辑来说要提出来一个组件 不过我懒了 -->
		<a-modal v-model:visible="addDriverVisible" title="添加司机信息" cancelText="取消" okText="确定" @ok="handleAddOk">
					<a-form name="driver_add_controllers" :model="driverAddController" @finish="onAddFinish">
				<a-form-item name="driverName" label="司机姓名">
					<a-input v-model:value="driverAddController.name" allow-clear />
				</a-form-item>
				<a-form-item name="driverAge" label="年龄">
					<a-input v-model:value="driverAddController.age" allow-clear />
				</a-form-item>
				<a-form-item name="driversex" label="司机性别">
					<a-input v-model:value="driverAddController.sex" allow-clear />
				</a-form-item>
				<a-form-item name="driverTel" label="手机号">
					<a-input v-model:value="driverAddController.tel" allow-clear />
				</a-form-item>
				<a-form-item name="driverCarId" label="车牌号">
					<a-input v-model:value="driverAddController.carId" allow-clear />
				</a-form-item>
				</a-form>
		</a-modal>
		<!-- 编辑弹窗结束 -->
		<!-- 派订单弹窗开始 -->
		<!-- 此处按照正常逻辑来说要提出来一个组件 不过我懒了 -->
		<a-modal v-model:visible="paiSongVisible" title="派送订单" cancelText="取消" okText="确定" @ok="paiSongOk">
			<a-form name="paiSong" :model="order" @finish="onAddFinish">
				<a-form-item name="orderId" label="订单号">
					<a-select v-model:value="driver.orderId" allow-clear placeholder="请选择订单号" style="width:180px">
					<template v-for="(item,index) in order" :key="index">
						<a-select-option :value="order[index].orderId">{{order[index].orderId}}</a-select-option>
					</template>
	
						
					</a-select>
				</a-form-item>
			</a-form>
		</a-modal>
		<!-- 派订单结束 -->
    </a-card>
</template>
<script lang="ts">
import { defineComponent, reactive,toRefs,ref, onMounted } from 'vue'
import { VxeTableInstance, VxeTableEvents,VxePagerEvents  } from 'vxe-table'
import { Icon } from '/@/utils/antdIcon';
import { message } from 'ant-design-vue';
import {findByPage,getDriverById,updateDriver,deleteDriver,addDriver,getDriverByName,getOrderId} from '/@/api/system/driver'
export default defineComponent({
    components: {
        Icon
    },
    setup() {
        const mainTable = ref({} as VxeTableInstance)
        const state=reactive({
            driverController:{
                current: 1,
                size:10,
                totalResult: 0
            },
			order:[],
            dataSource: [],
            loading: false,
            selectedRowKeys: [],
			editMenuVisible : false,
			driverEditController:{},
			addDriverVisible:false,
			paiSongVisible:false,
			driverAddController:{
				name:'',
				sex:'',
				age:'',
				carId:'',
				tel:''
			},
			driver:{
				orderId:''
			
			}
			
        })
        onMounted(()=>{
            loadData()
        })
        const loadData=()=>{
            state.loading=true
            findByPage(state.driverController).then(res=>{
                state.dataSource=res.data.records
                state.driverController.current=res.data.current
                state.driverController.size=res.data.size
                state.driverController.totalResult=res.data.total
            }).finally(()=>{
                state.loading=false
            })
        }   
        // 查询表单提交事件
        const onFinish=()=>{

        }
        // 控制新增按钮点击事件
        const handleAdd=()=>{
             state.addDriverVisible =true
        }
        // 控制批量删除事件
        const handleBatchDelete=()=>{

        }
        // 控制分页切换
        const handlePageChange:VxePagerEvents.PageChange = ({ currentPage, pageSize })=>{
			state.driverController.current=currentPage
			state.driverController.size=pageSize
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
        const handleEdit=(row:any)=>{
			state.editMenuVisible = true;
				getDriverById({ id: row.id })
				.then((res) => {
					state.driverEditController = res.data;
					
				})
				.finally(() => {
					state.editMenuVisible = true;
				});
        }
        const handleDel=(row:any)=>{
				state.loading = true;
			deleteDriver({id:row.id})
				.then((res) => {
					message.success(res.data);
				})
				.finally(() => {
					state.loading = false;
				});
			console.log(row);
        }
		const handleEditOk =()=>{
				updateDriver(state.driverEditController).then(res=>{
				message.success(res.data);
			}).finally(()=>{
				state.editMenuVisible = false;
				state.driverEditController={}
				loadData()
			})
		}
		const handleAddOk = ()=>{
				addDriver(state.driverAddController).then(res=>{
					message.success(res.data)
				}).finally(()=>{
					state.addDriverVisible = false
					state.driverAddController={
						name:'',
						age:'',
						sex:'',
						tel:'',
						carId:''
					}
				})
		}
		const search =  ()=>{
				getDriverByName(state.driverAddController.name).then(res=>{
						state.dataSource = res
					    state.driverController.totalResult =res.length
				}).finally(()=>{
					state.driverAddController.name = ''
				})
		}
		const handle=()=>{
			

state.paiSongVisible=true
			getOrderId().then(res=>{
				
				state.order =res.data
				console.log(state.order)
			})
		}
		const paiSongOk = ()=>{
			message.success('派单成功')
			state.paiSongVisible = false
		}
        return {
            ...toRefs(state),
            onFinish,
            handleBatchDelete,
            handlePageChange,
            handleEdit,
			handleAddOk,
            handleDel,
			 handleEditOk,
            selectAllChangeEvent1,
            mainTable,
            selectChangeEvent1,
            handleAdd,
			search,
			handle,
			paiSongOk
        }
    },
})
</script>
<style scoped>

</style>