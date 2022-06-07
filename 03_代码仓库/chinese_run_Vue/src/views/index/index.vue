<template>
    <a-card class="index-container">

        <div style="display: flex;flex-direction: row;align-items: center;justify-content: center">
          <div id="customerChart"> </div>

          <div id="PieChart"></div>

          <div id="Goods"></div>
        </div>
    </a-card>


     
</template>
<script>
import { defineComponent } from 'vue'
import { onMounted } from "vue";
import * as echarts from 'echarts'
export default defineComponent({
  name: "data_index",
    setup() {
           onMounted(() => { //需要获取到element,所以是onMounted的Hook

      let AllUser = echarts.init(document.getElementById("customerChart"));
      // 绘制用户图表
      AllUser.setOption({
        title: { text: "总用户量" },
        tooltip: {},
        xAxis: {
          data: ["5-23","5-24", "5-25", "5-26", "5-27", "5-28", "5-29"],
        },
        yAxis: {},
        series: [
          {
            name: "用户量",
            type: "line",
            data: [5, 20, 36, 10, 10, 20],
          },
        ],
      });
      window.onresize = function () {//自适应大小
        AllUser.resize();
      };

     let AllOrder = echarts.init(document.getElementById("PieChart"));
     // 绘制订单表
      AllOrder.setOption({
        title: { text: "总订单量",
                 left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
           orient: 'vertical',
           left: 'left'
  },
        series: [
          {
           name: 'Access From',
           type: 'pie',
           radius: '50%',
           data: [
        { value: 1048, name: '今日运输量' },
        { value: 735, name: '出库订单数' },
        { value: 580, name: '入库订单数' },
        { value: 484, name: '剩余商品数' },
        { value: 300, name: '尚未处理订单' }
      ],
       emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
          },
        ],
      });
      window.onresize = function () { //自适应大小
        AllOrder.resize();
      };    
       
       // 商品数量
       let Goods = echarts.init(document.getElementById("Goods"));
        Goods.setOption({
          title: { text: "商品种类",
                 left: 'center'
        },
        xAxis: {
            type: 'category',
            data: [ '酒水饮料', '电子产品', '日用品', '水果']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: [120, 200, 150, 80],
                type: 'bar'
            }
        ],
      });
      window.onresize = function () { //自适应大小
        Goods.resize();
      };    

    });
  }
      })
</script>

<style scoped>
 .activity-container >>> .ant-card-body{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

#customerChart{
    width: 420px;
    height:350px; 
    margin-bottom: 20px
}

#PieChart{
    width:500px;
    height:370px; 
    margin-bottom: 10px
}

#Goods{
     width:450px;
    height:350px; 
}

</style>