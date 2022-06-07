<template>
  <a-card class="activity-container">
    <!-- 表格查询部分开始 -->
    <div class="data-form">
      <a-form name="menu_controllers" layout="inline" :model="tenantController" @finish="onFinish">
        <a-form-item name="tenantName" label="租户名称">
          <a-input v-model:value="tenantController.tenantName" allow-clear placeholder="输入租户名称查询" />
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
      <vxe-column field="tenantNo" title="租户名称"></vxe-column>
      <vxe-column field="tenantName" show-overflow title="菜单描述"></vxe-column>
      <vxe-column field="tenantEmail" title="租户邮箱"></vxe-column>
      <vxe-column field="tenantUsername" title="租户账号"></vxe-column>
      <vxe-column field="createBy" title="创建人"></vxe-column>
      <vxe-column field="modifyBy" title="修改人"></vxe-column>
      <vxe-column field="created" title="创建时间"></vxe-column>
      <vxe-column field="lastUpdateTime" title="修改时间"></vxe-column>
      <vxe-column width="200px" title="操作">
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
        v-model:current-page="tenantController.current"
        v-model:page-size="tenantController.size"
        :total="tenantController.totalResult"
        @page-change="handlePageChange"
        :layouts="['PrevJump', 'PrevPage', 'JumpNumber', 'NextPage', 'NextJump', 'Sizes', 'FullJump', 'Total']"
    >
    </vxe-pager>
    <!-- 分页模块结束 -->
  </a-card>
</template>
<script lang="ts">
import {defineComponent, onMounted, reactive, ref, toRefs} from "vue";
import { Icon } from '/@/utils/antdIcon';
import { VxeTableInstance, VxeTableEvents, VxePagerEvents } from 'vxe-table';
import { message } from 'ant-design-vue';
import {findByPage} from '/@/api/base/tenant/index'
export default defineComponent({
  name: 'tenant_index',
  components:{
    Icon
  },
  setup(){
    const mainTable = ref({} as VxeTableInstance);
    const state=reactive({
      tenantController:{
        tenantName: ""
      },
      selectedRowKeys: [],
      loading:false,
      dataSource: [],
      selectedRowKeys:[]
    })
    onMounted(()=>{
      loadData()
    })
    const loadData=()=>{
      state.loading=true
      findByPage(state.tenantController).then(res=>{
        state.dataSource=res.data.records
      }).finally(()=>{
        state.loading=false
      })
    }
    const onFinish=()=>{
      loadData()
    }
    const handleAdd=()=>{

    }
    const handleBatchDelete=()=>{

    }
    const handlePageChange=()=>{

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
    return {
      ...toRefs(state),
      onFinish,
      selectAllChangeEvent1,
      selectChangeEvent1,
      handleAdd,
      handleBatchDelete,
      handlePageChange
    }
  }
})
</script>
<style lang="scss">

</style>