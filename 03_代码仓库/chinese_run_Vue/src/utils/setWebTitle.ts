import { nextTick } from 'vue';
import router from '/@/router/index';
import { store } from '/@/store/index';

/**
 * 设置浏览器标题国际化
 */
export function useTitle() {
	return () => {
		nextTick(() => {
			let webTitle = '';
			let globalTitle: string = store.state.themeConfig.themeConfig.globalTitle;
			router.currentRoute.value.path === '/login'
				? (webTitle = router.currentRoute.value.meta.title as any)
				: null;
			document.title = `${webTitle} - ${globalTitle}` || globalTitle;
		});
	};
}
