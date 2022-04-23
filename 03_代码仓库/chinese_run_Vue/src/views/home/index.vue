<template>
	<main class="app-container">
		<!-- 侧边栏 -->
		<section class="app-sidebar">
			<SideBar v-model:isOpen="isOpen" />
		</section>
		<!-- 主体内容开始 -->
		<section class="app-body">
			<section class="app-header">
				<AppHeader @handleToggle="handleToggle" />
			</section>
			<section class="app-nav">
				<AppNavBar />
			</section>
			<section class="app-content">
				<router-view />
			</section>
		</section>
		<section class="app-desc">
			<BottomInfo />
		</section>
		<!-- 头部栏开始 -->
		<!-- 头部栏结束 -->
		<!-- 页面栏开始 -->
		<!-- 页面栏结束 -->
		<!-- 公司介绍栏开始 -->
		<!-- 公司介绍栏介绍s -->
		<!-- 主体内容结束 -->
	</main>
</template>
<script>
import { defineComponent, reactive, toRefs } from 'vue';
import SideBar from '/@/components/SideBar.vue';
import AppHeader from '/@/components/AppHeader.vue';
import AppNavBar from '/@/components/AppNavBar.vue';
import BottomInfo from '/@/components/BottomInfo.vue';
export default defineComponent({
	components: {
		SideBar,
		AppHeader,
		AppNavBar,
		BottomInfo,
	},
	setup() {
		const state = reactive({
			isOpen: true,
		});
		const handleToggle = (val) => {
			state.isOpen = val;
		};
		return {
			...toRefs(state),
			handleToggle,
		};
	},
});
</script>
<style lang="scss" scoped>
.app-container {
	min-height: 100%;
	display: flex;
	flex-direction: row;
	.app-sidebar {
		background: rgb(255, 255, 255);
		max-width: 14vw;
		height: 100vh;
	}
	.app-nav {
		background: rgb(255, 255, 255);
	}
	.app-body {
		flex: 1;
		.app-header {
			min-width: 86vw;
			height: 7vh;
		}
		.app-content{
			height: 80vh;
			box-sizing: border-box;
			padding: 10px;
		}
	}
	.app-desc {
		width: 100vw;
		position: absolute;
		bottom: 0;
		background: rgb(255, 255, 255);
	}
}
</style>
