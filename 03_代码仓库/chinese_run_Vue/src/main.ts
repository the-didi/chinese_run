import { createApp } from 'vue'
import App from './App.vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import router from './router';
import { store, key } from './store';
import mitt from 'mitt';
import screenShort from 'vue-web-screen-shot';
import '/@/theme/index.scss';
createApp(App).use(router)
.use(store, key).use(screenShort, { enableWebRtc: false }).use(Antd).mount('#app')
