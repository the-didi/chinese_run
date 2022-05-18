<template>
	<div class="container">
		<div class="forms-container">
			<div class="signin-signup">
				<form action="#" class="sign-in-form">
					<h2 class="title">华润物流科技</h2>
					<div class="input-field">
						<i class="fas fa-user"></i>
						<input type="text" v-model="loginForm.username" placeholder="Username" />
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i>
						<input type="password" v-model="loginForm.password" placeholder="Password" />
					</div>
					<input type="submit" value="登录" @click="handleLogin" class="btn solid" />
				</form>
				<form action="#" class="sign-up-form">
					<h2 class="title">Sign up</h2>
					<div class="input-field">
								<i class="fas fa-user"></i>
						<input type="text" placeholder="Username" />
					</div>
					<div class="input-field">
						<i class="fas fa-envelope"></i>
						<input type="email" placeholder="Email" />
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i>
						<input type="password" placeholder="Password" />
					</div>
					<input type="submit" class="btn" value="Sign up" />
				</form>
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<!-- <button class="btn transparent" id="sign-up-btn">Sign up</button> -->
				</div>
				<img src="/log.svg" class="image" alt="" />
			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>One of us ?</h3>
					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum laboriosam ad deleniti.</p>
					<!-- <button class="btn transparent" id="sign-in-btn">Sign in</button> -->
				</div>
				<img src="/register.svg" class="image" alt="" />
			</div>
		</div>
	</div>
</template>
<script>
import { defineComponent, reactive, toRefs } from 'vue';
import router from '/@/router/index';
import { useStore } from '/@/store/index';
import { Session } from '/@/utils/storage';
import { getUserInfo } from '/@/api/login/index';
export default defineComponent({
	setup() {
		const store = useStore();
		const state = reactive({
			loginForm: {
				username: '',
				password: '',
			},
		});
		// 控制登录
		const handleLogin = async () => {
			// 首先走登录保存token
			store.dispatch('userInfos/userLogin', state.loginForm);
			// token保存完毕之后加载用户信息
			const userInfo = await getUserInfo({ username: state.loginForm.username });
			// 用户信息得到保存
			store.dispatch('userInfos/setUserInfos', userInfo.data);

			signInSuccess();
		};
		// 登录成功的处理路由
		const signInSuccess = (res) => {
			Session.set('tabviews', [
				{
					title: '大盘数据',
					content: 'index',
					key: '/index',
				},
			]);
			router.push('/');
		};
		return {
			handleLogin,
			...toRefs(state),
		};
	},
});
</script>

<style lang="scss" scoped>
@import url('/@/theme/login_style.scss');
</style>