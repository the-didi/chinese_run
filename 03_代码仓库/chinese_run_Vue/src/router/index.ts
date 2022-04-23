import { createRouter, createWebHashHistory } from 'vue-router';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { Session } from '/@/utils/storage';
import { NextLoading } from '/@/utils/loading';
import { staticRoutes} from '/@/router/route';



/**
 * 创建一个可以被 Vue 应用程序使用的路由实例
 * @method createRouter(options: RouterOptions): Router
 * @link 参考：https://next.router.vuejs.org/zh/api/#createrouter
 */
 const router = createRouter({
	history: createWebHashHistory(),
	routes: staticRoutes,
});


// 路由加载前
router.beforeEach(async (to, from, next) => {
	NProgress.configure({ showSpinner: false });
	if (to.meta.title) NProgress.start();
	NextLoading.start()
	const token = Session.get('token');
	if (to.path === '/login' && !token) {
		next();
		NProgress.done();
	} else {
		if (!token) {
			// next(`/login?redirect=${to.path}&params=${JSON.stringify(to.query ? to.query : to.params)}`);
			// Session.clear();
			NProgress.done();
		} else {
				next();
			}
		next()
		NProgress.done();
	}
});

// 路由加载后
router.afterEach(() => {
	NProgress.done();
	NextLoading.done();
});

// 导出路由
export default router;