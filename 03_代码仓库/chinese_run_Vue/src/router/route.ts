import { RouteRecordRaw } from 'vue-router';
import IndexLayout from '/@/layouts/index/index.vue'
/**
 * 路由meta对象参数说明
 * meta: {
 *      title:          菜单栏及 tagsView 栏、菜单搜索名称（国际化）
 *      isLink：        是否超链接菜单，开启外链条件，`1、isLink:true 2、链接地址不为空`
 *      isHide：        是否隐藏此路由
 *      isKeepAlive：   是否缓存组件状态
 *      isAffix：       是否固定在 tagsView 栏上
 *      isIframe：      是否内嵌窗口，，开启条件，`1、isIframe:true 2、链接地址不为空`
 *      auth：          当前路由权限标识（多个请用逗号隔开），最后转成数组格式，用于与当前用户权限进行对比，控制路由显示、隐藏
 *      icon：          菜单、tagsView 图标，阿里：加 `iconfont xxx`，fontawesome：加 `fa xxx`
 * }
 */

/**
 * 定义动态路由
 * @description 未开启 isRequestRoutes 为 true 时使用（前端控制路由），开启时第一个顶级 children 的路由将被替换成接口请求回来的路由数据
 * @description 各字段请查看 `/@/views/system/menu/component/addMenu.vue 下的 ruleForm`
 * @returns 返回路由菜单数据
 */
export const dynamicRoutes: Array<RouteRecordRaw> = []

/**
* 定义静态路由
* @description 前端控制直接改 dynamicRoutes 中的路由，后端控制不需要修改，请求接口路由数据时，会覆盖 dynamicRoutes 第一个顶级 children 的内容（全屏，不包含 layout 中的路由出口）
* @returns 返回路由菜单数据
*/
export const staticRoutes: Array<RouteRecordRaw> = [
	// 登录页面 单独布局就给他提出来
	{
		path: '/login',
		name: 'login',
		component: () => import('/@/views/login/index.vue'),
		meta: {
			title: '登录',
		},
	},
	{
		path: '/',
		name: 'home',
		component: ()=>import('/@/views/home/index.vue'),
		meta: {
			title: '大盘数据'
		},
		redirect: '/index',
		children: [
			{
				path: '/index',
				name: 'Index',
				component:()=>import('/@/views/index/index.vue'),
				meta: {
					title: '大盘数据'
				}
			},
			{
				path:'/base/goods',
				name: 'Goods',
				component : () => import ('/@/views/base/goods/index.vue'),
				meta:{
					title : '商品'
				}

			},{
				path: '/base/goods_details' ,
				component : () => import('/@/views/base/goods_details/index.vue'),
				meta:{
					title: '商品明细'
				}
			},
			{
				path: '/menu',
				name: 'Menu',
				component: ()=>import('/@/views/system/menu/index.vue'),
				meta: {
					title: '菜单管理'
				}
			},
			{
				path: '/demo',
				name: 'Demo',
				component: ()=>import('/@/views/demo/index.vue'),
				meta: {
					title: '样例'
				}
			},
			{
				path: '/role',
				name: 'Role',
				component: ()=>import('/@/views/system/role/index.vue'),
				meta: {
					title: '权限管理'
				}
			},
			{
				path:'/user',
				name: 'User',
				component: ()=>import("/@/views/system/user/index.vue"),
				meta:{
					title: '用户管理'
				}
			},
			{
				path:'/driver',
				name: 'Driver',
				component: ()=>import("/@/views/system/driver/index.vue"),
				meta:{
					title: '司机管理'
				}
			},
			{
				path:'/order',
				name: 'Order',
				component: ()=>import("/@/views/system/order/index.vue"),
				meta:{
					title: '订单管理'
				}
			},
			{
				path:'/transport',
				name: 'transport',
				component: ()=>import("/@/views/system/transport/index.vue"),
				meta:{
					title: '运输管理'
				}
			},
			{
				path: '/online/cgform',
				name: 'CgForm',
				component: ()=>import("/@/views/online/cgform/index.vue"),
				meta: {
					title: '在线表单开发'
				}
			},
			{
				path: '/warehouse/reservoir',
				name: 'reservoir',
				component: ()=>import("/@/views/warehouse/reservoir/index.vue"),
				meta: {
					title: '库区配置'
				}
			},
			{
				path: '/warehouse/storage',
				name: 'storage',
				component: ()=>import("/@/views/warehouse/storage/index.vue"),
				meta: {
					title: '储区配置'
				}
			},
			{
				path: '/warehosue/cargospace',
				name: 'cargospace',
				component: ()=>import("/@/views/warehouse/cargospace/index.vue"),
				meta: {
					title: "货位配置"
				}
			},{
				path:'/base/out',
				component:()=>import('/@/views/exwarehouse/base/index.vue'),
				meta:{
					title:'一般出库'
				}
			},
			{
				path:'/other/out',
				component:()=>import('/@/views/exwarehouse/other/index.vue'),
				meta:{
					title:'其他出库'
				}
			}
		]
	}

]