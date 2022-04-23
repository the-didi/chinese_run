<template>
	<div class="header-container">
		<div class="header-container-left">
			<a-button style="color: #fff" type="text" @click="toggleCollapsed">
				<MenuUnfoldOutlined v-if="collapsed" />
				<MenuFoldOutlined v-else />
			</a-button>
			<div class="title">欢迎进入华润物流供应链一体化云平台</div>
		</div>
		<div class="header-container-right">
			<!-- 搜索栏开始 -->
			<div class="search-group">
				<a-button style="color: #fff" @click="showSearch = !showSearch" type="text">
					<SearchOutlined />
				</a-button>
				<a-select
					v-show="showSearch"
					v-model:value="searchValue"
					show-search
					placeholder="请输入菜单名称"
					style="width: 200px"
					:options="options"
					@change="handleChange"
				></a-select>
			</div>
			<!-- 搜索栏结束 -->
			<!-- 帮助文档开始 -->
			<a-button style="color: #fff" @click="handleQuestionDoc" type="text">
				<QuestionCircleOutlined />
			</a-button>
			<!-- 帮助文档结束 -->
			<!-- 系统通知开始 -->
			<a-popover placement="bottom">
				<template #content>
					<a-tabs v-model:activeKey="activeKey">
						<a-tab-pane key="1" tab="通知"></a-tab-pane>
						<a-tab-pane key="2" tab="系统信息" force-render></a-tab-pane>
					</a-tabs>
					<a-button size="small" style="width: 100%" type="dashed" @click="handleNoticeMore">查看更多</a-button>
				</template>
				<a-button style="color: #fff" type="text">
					<NotificationOutlined />
				</a-button>
			</a-popover>
			<!-- 系统通知结束 -->
			<!-- 用户中心开始 -->
			<a-dropdown  type="text">
                <a-button type="text" style="display:flex;flex-direction:row;align-items:center">
                    <img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F94181cf7bd627fe1d11ab0c313e82a3040896a8782cf3-ld5dgM_fw658&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653152001&t=ce6932bc668ef99190d6a72b9749015c" style="width:30px;height:30px;border-radius:50%" alt="">
                     <span style="color: #fff;font-size:16px;margin-left:5px">欢迎您,管理员</span>
                </a-button>
				<template #overlay>
					<a-menu @click="handleMenuClick">
						<a-menu-item key="1">
							<UserOutlined />
							个人中心
						</a-menu-item>
					</a-menu>
				</template>
			</a-dropdown>
			<!-- 用户中心结束 -->
			<!-- 推出登录开始 -->
			<a-button style="color: #fff" type="text">
				<template #icon><LogoutOutlined /></template>
				退出登录
			</a-button>
			<!-- 退出登录结束 -->
		</div>
	</div>
</template>
<script lang="ts">
import { defineComponent } from 'vue';
import {
	MenuFoldOutlined,
	MenuUnfoldOutlined,
	SearchOutlined,
	QuestionCircleOutlined,
	NotificationOutlined,
	LogoutOutlined,
    UserOutlined
} from '@ant-design/icons-vue';
import { reactive, ref, toRefs } from '@vue/reactivity';
import type { SelectProps } from 'ant-design-vue';
export default defineComponent({
	components: {
		MenuFoldOutlined,
		MenuUnfoldOutlined,
		SearchOutlined,
		QuestionCircleOutlined,
		NotificationOutlined,
		LogoutOutlined,
        UserOutlined
	},
	emits: ['handleToggle'],
	setup(props, context) {
		const options = ref<SelectProps['options']>([
			{
				value: 'a1',
				label: 'a1',
			},
		]);
		const state = reactive({
			collapsed: false,
			showSearch: false,
			searchValue: null,
			activeKey: 1,
		});
		const toggleCollapsed = () => {
			state.collapsed = !state.collapsed;
			context.emit('handleToggle', state.collapsed);
		};
		const handleChange = (value: string) => {
			state.showSearch = false;
			console.log(value);
		};
		const handleQuestionDoc = () => {
			window.open('http://www.freeprogramming.cn');
		};
		return {
			handleQuestionDoc,
			toggleCollapsed,
			handleChange,
			options,
			...toRefs(state),
		};
	},
});
</script>
<style lang="scss" scoped>
.header-container {
	width: 100%;
	height: 100%;
	color: #fff;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	box-sizing: border-box;
	background: rgb(24, 144, 255);
	padding: 0 0.5rem;
	.header-container-left {
		display: flex;
		flex-direction: row;
		align-items: center;
		.title {
			font-size: 18px;
			margin-left: 0.32rem;
		}
	}
	.header-container-right {
		display: flex;
		flex-direction: row;
		align-items: center;
		width: auto;
		.search-group {
			display: flex;
			flex-direction: row;
			align-items: center;
		}
	}
}
</style>
