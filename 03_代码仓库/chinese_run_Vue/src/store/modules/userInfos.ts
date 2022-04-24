import { Module } from 'vuex';
import { Session } from '/@/utils/storage';
import {login} from '/@/api/login/index'
// 此处加上 `.ts` 后缀报错，具体原因不详
import { UserInfosState, RootStateTypes } from '/@/store/interface/index';
import { element } from 'screenfull';

const userInfosModule: Module<UserInfosState, RootStateTypes> = {
	namespaced: true,
	state: {
		userInfos: {},
		menuList: []
	},
	mutations: {
		// 设置用户信息
		getUserInfos(state: any, data: object) {
			state.userInfos = data;
		},
		// 设置菜单信息
		setMenuList(state: any,data: object){
			state.menuList=data
		}
	},
	actions: {
		// 设置用户信息
		async setUserInfos({ commit }, data: object) {
			console.log("这里打印用户信息")
			console.log(data)
			if (data) {
				commit('getUserInfos', data);
				Session.set("userInfo",data)
			} else {
				if (Session.get('userInfo')) commit('getUserInfos', Session.get('userInfo'));
			}
		},
		async userLogin({commit},data: any) {
			const res=await login(data)
			// 获取token之后获取登录用户信息
			Session.set('Authorization',res.token)
			let menus=res.menus
			// 设置菜单信息
			commit('setMenuList',menus)
			console.log("开始执行转化函数")
			Session.set('MenuList',arrayToTree(menus))
		}
	},
};
function arrayToTree(menuList:any){
	
	let parentList=[]
	menuList.forEach(element => {
		if(element.parentId==null){
			parentList.push(element)
		}
	});
	menuList.forEach(element=>{
		if(element.parentId!=null){
			for(let item of parentList){
				if(element.parentId==item.id){
					item.childs.push(element)
				}
			}
		}
	})
	return parentList
}
export default userInfosModule;
