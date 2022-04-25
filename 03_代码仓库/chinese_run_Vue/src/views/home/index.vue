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

		<!-- 头部栏开始 -->
		<!-- 头部栏结束 -->
		<!-- 页面栏开始 -->
		<!-- 页面栏结束 -->
		<!-- 公司介绍栏开始 -->
		<!-- 公司介绍栏介绍s -->
		<!-- 主体内容结束 -->
	</main>
	<a-affix :offset-bottom="0">
		<section class="app-desc">
		<BottomInfo />
	</section>
	</a-affix>	
	
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
	min-height: 100vh;
	display: flex;
	flex-direction: row;
	.app-sidebar {
		background: rgb(255, 255, 255);
		max-width: 14vw;
		height: inherit;
	}

	.app-body {
		flex: 1;
		height: inherit;
		.app-header {
			min-width: 86vw;
			height: 7vh;
		}
		.app-nav {
			height: 7vh;
			background: rgb(255, 255, 255);
		}
		.app-content {
			min-height: 80vh;
			box-sizing: border-box;
			padding: 10px;
		}
	}
	
}
.app-desc {
		border-top: 1px solid #DCDFE6;
		width: 100vw;
		background: rgb(255, 255, 255);
	}
</style>
