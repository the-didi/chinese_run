<template>
        <a-card class="activity-container">
                <!-- 商品查询模块开始 -->
                <div class="data-form">
                        <a-form name="reservoir_controllers" layout="inline" :model="goodsDetaisController"
                                @finish="onFinish">
                                <a-form-item name="reservoirCode" label="货主">
                                        <a-input v-model:value="goodsDetaisController.hName" allow-clear
                                                placeholder="输入货主姓名" />
                                </a-form-item>
                                <a-form-item>
                                        <a-button type="primary" html-type="submit" @click="search()">
                                                <template #icon>
                                                        <Icon icon="SearchOutlined" />
                                                </template>
                                                查询
                                        </a-button>
                                </a-form-item>
                                <a-form-item>
                                        <a-button type="primary" html-type="submit" @click="reset()">
                                                重置
                                        </a-button>
                                </a-form-item>
                        </a-form>
                </div>
                <!-- 商品查询模块结束 -->
                <!-- 按钮组模块开始 -->
                <div class="btn-group">
                        <a-button type="primary" @click="handleAdd">
                                <template #icon>
                                        <Icon icon="PlusOutlined" />
                                </template>
                                新增
                        </a-button>
                        <a-button type="primary" style="margin-left: 5px" v-if="selectedRowKeys.length != 0"
                                @click="handleBatchDelete">
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
                        <span style="margin-left: 5px">已选择&nbsp;<a style="font-weight: 600">{{ selectedRowKeys.length
                        }}</a>项&nbsp;&nbsp;</span>
                        <a style="margin-left: 24px" @click="onClearSelected">清空</a>
                </div>
                <vxe-table border ref="mainTable" :row-config="{ keyField: 'id' }" :column-config="{ resizable: true }"
                        align="center" height="500" :loading="loading" :data="dataSource"
                        @checkbox-all="selectAllChangeEvent1" @checkbox-change="selectChangeEvent1">
                        <vxe-column type="seq" width="60" title="#"></vxe-column>
                        <vxe-column type="checkbox" width="60"></vxe-column>
                        <vxe-column field="gName" title="货主"></vxe-column>
                        <vxe-column field="gNO" title="商品编码"></vxe-column>
                        <vxe-column field="gSKU" title="商品SKU"></vxe-column>
                        <vxe-column field="gName" title="品名"></vxe-column>
                        <vxe-column field="jifei" title="计费商品类"></vxe-column>
                        <vxe-column field="unit" title="单位"></vxe-column>
                        <vxe-column field="cunfangwencun" title="存放温层"></vxe-column>
                        <vxe-column field="dancheng" title="单层"></vxe-column>
                        <vxe-column field="chenggao" title="层高"></vxe-column>
                        <vxe-column field="baozhiqi" title="保质期"></vxe-column>
                        <vxe-column field="tiji" title="体积"></vxe-column>
                        <vxe-column field="weight" title="重量"></vxe-column>
                        <vxe-column field="zlNumber" title="折零数量"></vxe-column>
                        <vxe-column field="gProperty" title="产品属性"></vxe-column>
                        <vxe-column field="baseUnit" title="基本单位"></vxe-column>
                        <vxe-column width="200px" title="操作">
                                <template #default="{ row }">
                                        <a-button type="link" @click="handleEdit(row)">编辑</a-button>
                                        <a-button type="link" @click="handleDel(row)">删除</a-button>
                                </template>
                        </vxe-column>
                </vxe-table>
                <!-- 数据表格模块结束 -->
                <!-- 分页模块开始 -->
                <vxe-pager background v-model:current-page="goodsDetaisController.current"
                        v-model:page-size="goodsDetaisController.size" :total="goodsDetaisController.totalResult"
                        @page-change="handlePageChange"
                        :layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']">
                </vxe-pager>
                <!-- 分页模块结束 -->
                <!-- 编辑弹出窗开始 -->
                <!-- 编辑弹窗开始 -->
                <a-modal v-model:visible=" editGoodsDetaisVisible" title="编辑商品信息" cancelText="取消" okText="确定" @ok="handleEditOk">
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                         <a-form name="driver_add_controllers"  @finish="onAddFinish">
                                <a-form-item  label="货主姓名">
                                        <a-input allow-clear />
                                </a-form-item>
                        </a-form>
                </a-modal>
                <!-- 编辑弹出框结束 -->

                <!-- 添加弹出框开始 -->
                <a-modal v-model:visible="addGoodsDetailsVisible" title="添加商品信息" cancelText="取消" okText="确定" @ok="handleAddOk">
      
                </a-modal>
                <!--  添加弹出框结束-->
        </a-card>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs, ref, onMounted } from 'vue';
import { Icon } from '/@/utils/antdIcon';
import { VxeTableInstance, VxeTableEvents, VxePagerEvents } from 'vxe-table';
import { message } from 'ant-design-vue';
export default defineComponent({
        components: {
                Icon
        },
        setup() {
                const mainTable = ref({} as VxeTableInstance);
                const state = reactive({
                        goodsDetaisController: {
                                current: 1,
                                size: 10,
                                totalResult: 0
                        },
                        dataSource: [
                                {
                                        gName:'测试',
                                        gNo:'11111',
                                        gSKU:'123123',
                                        pName:'测试',
                                        jifei:'是',
                                        unit:'kg',
                                        cunfangwencun:'是',
                                        chneggao:'12m',
                                        baozhiqi:'永久',
                                        tiji:"120",
                                        weight:"123",
                                        zlNumber:'2',
                                        gProperty:"一般",
                                        base:'t'
                                }
                        ],
                        loading: false,
                        selectedRowKeys: [],
                        addGoodsDetailsVisible:false,
                        editGoodsDetaisVisible:false,
                        addGoodDetailsController:[],
                        editGoodsDetailsController:[]
                });
                onMounted(() => {
                        loadData()
                })
                const handleAdd = () => {
                        state.addGoodsDetailsVisible = true
                }
                const loadData = () => {

                }
                const handleBatchDelete = () => {

                }
                const onFinish = () => { };
                const onClearSelected = () => {

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
                const handleEdit = () => {
                                state.editGoodsDetaisVisible = true;
                }
                const handleMenuClick = () => {

                }
                const handlePageChange: VxePagerEvents.PageChange = ({ currentPage, pageSize }) => {

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
