<template>
        <a-card class="activity-container">
                <!-- 商品查询模块开始 -->
                <div class="data-form">
                        <a-form name="reservoir_controllers" layout="inline" :model="goodsController"
                                @finish="onFinish">
                                <a-form-item name="reservoirCode" label="所属货主">
                                        <a-input v-model:value="goodsController.hName" allow-clear
                                                placeholder="输入货主姓名" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="商品名称">
                                        <a-input v-model:value="goodsController.gName" allow-clear
                                                placeholder="请输入商品名称" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="英文名称">
                                        <a-input v-model:value="goodsController.eName" allow-clear
                                                placeholder="输入英文名称" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="商品编码">
                                        <a-input v-model:value="goodsController.gNO" allow-clear
                                                placeholder="输入商品编码" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="客户编码">
                                        <a-input v-model:value="goodsController.cNO" allow-clear
                                                placeholder="输入客户商品编码" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="产品属性">
                                        <a-input v-model:value="goodsController.gProperties" allow-clear
                                                placeholder="输入产品属性" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="商品类目">
                                        <a-input v-model:value="goodsController.gCategory" allow-clear
                                                placeholder="输入商品类目" />
                                </a-form-item>
                                <a-form-item name="reservoirCode" label="商品条码">
                                        <a-input v-model:value="goodsController.gTiaoma" allow-clear
                                                placeholder="输入商品条码" />
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
                        <vxe-column field="hName" title="所属货主"></vxe-column>
                        <vxe-column field="gName" title="商品名称"></vxe-column>
                        <vxe-column field="eName" title="英文名字"></vxe-column>
                        <vxe-column field="gNo" title="商品编码"></vxe-column>
                        <vxe-column field="cNo" title="客户编码"></vxe-column>
                        <vxe-column field="gGuige" title="商品规格"></vxe-column>
                        <vxe-column field="gProperties" title="产品属性"></vxe-column>
                        <vxe-column field="gcategort" title="商品类目"></vxe-column>
                        <vxe-column field="zl" title="拆零控制"></vxe-column>
                        <vxe-column width="200px" title="操作">
                                <template #default="{ row }">
                                        <a-button type="link" @click="handleEdit(row)">编辑</a-button>
                                        <a-button type="link" @click="handleDel(row)">删除</a-button>
                                </template>
                        </vxe-column>
                </vxe-table>
                <!-- 数据表格模块结束 -->
                <!-- 分页模块开始 -->
                <vxe-pager background v-model:current-page="goodsController.current"
                        v-model:page-size="goodsController.size" :total="goodsController.totalResult"
                        @page-change="handlePageChange"
                        :layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']">
                </vxe-pager>
                <!-- 分页模块结束 -->
                <!-- 编辑弹窗开始 -->
                <a-modal v-model:visible="editGoodsVisible" title="编辑商品信息" cancelText="取消" okText="确定" @ok="handleEditOk">
                        <a-form name="driver_add_controllers" :model="goodsEditController" @finish="onAddFinish">
                                <a-form-item name="driverName" label="货主姓名">
                                        <a-input v-model:value="goodsEditController.hName" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品名称">
                                        <a-input v-model:value="goodsEditController.gName" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="英文名字">
                                        <a-input v-model:value="goodsEditController.eName" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品编码">
                                        <a-input v-model:value="goodsEditController.gNO" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="客户商品编码">
                                        <a-input v-model:value="goodsEditController.cNO" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品规格">
                                        <a-input v-model:value="goodsEditController.gGuige" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="产品属性">
                                        <a-input v-model:value="goodsEditController.gProperties" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品类目">
                                        <a-input v-model:value="goodsEditController.gCategory" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="折零控制">
                                        <a-input v-model:value="goodsEditController.zl" allow-clear />
                                </a-form-item>

                        </a-form>
                </a-modal>
                <!-- 编辑弹窗结束 -->
                <!-- 添加弹窗开始 -->
                <a-modal v-model:visible="addGoodsVisible" title="添加商品" cancelText="取消" okText="确定" @ok="handleAddOk">
                        <a-form name="driver_add_controllers" :model="goodsAddController" @finish="onAddFinish">
                                <a-form-item name="driverName" label="货主姓名">
                                        <a-input v-model:value="goodsAddController.hName" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品名称">
                                        <a-input v-model:value="goodsAddController.gNmae" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="英文名字">
                                        <a-input v-model:value="goodsAddController.eName" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品编码">
                                        <a-input v-model:value="goodsAddController.gNO" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="客户商品编码">
                                        <a-input v-model:value="goodsAddController.cNO" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品规格">
                                        <a-input v-model:value="goodsAddController.gguige" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="产品属性">
                                        <a-input v-model:value="goodsAddController.gProperties" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="商品类目">
                                        <a-input v-model:value="goodsAddController.gcategory" allow-clear />
                                </a-form-item>
                                <a-form-item name="driverName" label="折零控制">
                                        <a-input v-model:value="goodsAddController.zl" allow-clear />
                                </a-form-item>
                        </a-form>
                </a-modal>
                <!-- 添加弹窗结束 -->
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
                        goodsController: {
                                current: 1,
                                size: 10,
                                totalResult: 0
                        },
                        dataSource: [
                                {       
                                        hName:'测试',
                                        gName:'测试',
                                        eName:'测试',
                                        gNO:'1111',
                                        cNO:'11111',
                                        gGuige:'测试',
                                        gProperties:'测试',
                                        gCategory:'测试',
                                        zl:'否'


                                }

                        ],
                        loading: false,
                        selectedRowKeys: [],
                        editGoodsVisible: false,
                        addGoodsVisible: false,
                        goodsEditController: [
                                 {     
                                        hName:'测试',
                                        gName:'测试',
                                        eName:'测试',
                                        gNO:'1111',
                                        cNO:'11111',
                                        gGuige:'测试',
                                        gProperties:'测试',
                                        gCategory:'测试',
                                        zl:'否'


                                }]
                        ,
                        goodsAddController: [
                                 {       
                                        hName:'',
                                        gName:'',
                                        eName:'',
                                        gNO:'',
                                        cNO:'',
                                        gGuige:'',
                                        gProperties:'',
                                        gCategory:'',
                                        zl:''


                                }

                        ]

                });
                onMounted(() => {
                        loadData()
                })
                const handleAdd = () => {
                                state.addGoodsVisible = true
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
                                // 单击时让添加菜单显示
                                state.editGoodsVisible=true;
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
