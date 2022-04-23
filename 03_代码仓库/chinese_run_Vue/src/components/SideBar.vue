<template>
    <div class="company-logo">
        <span v-if="isOpen">华润</span>
        <div v-else>
            <img src="/logo.png" style="width:30px;height:30px" alt="Logo chinese_run">
            <span style="margin-left:.5rem">华润物流</span>
        </div>
    </div>
	<a-menu v-model:openKeys="openKeys" v-model:selectedKeys="selectedKeys" mode="inline" :inline-collapsed="isOpen">
		<a-menu-item key="1">
			<template #icon>
				<PieChartOutlined />
			</template>
			<span>Option 1</span>
		</a-menu-item>
		<a-menu-item key="2">
			<template #icon>
				<DesktopOutlined />
			</template>
			<span>Option 2</span>
		</a-menu-item>
		<a-menu-item key="3">
			<template #icon>
				<InboxOutlined />
			</template>
			<span>Option 3</span>
		</a-menu-item>
		<a-sub-menu key="sub1">
			<template #icon>
				<MailOutlined />
			</template>
			<template #title>Navigation One</template>
		</a-sub-menu>
		<a-sub-menu key="sub2">
			<template #icon>
				<AppstoreOutlined />
			</template>
			<template #title>Navigation Two</template>
		</a-sub-menu>
	</a-menu>
</template>
<script lang="ts">
import { computed, defineComponent, onMounted, reactive, toRefs, watch } from 'vue';
import {
	MenuFoldOutlined,
	MenuUnfoldOutlined,
	PieChartOutlined,
	MailOutlined,
	DesktopOutlined,
	InboxOutlined,
	AppstoreOutlined,
} from '@ant-design/icons-vue';
import {useStore} from '/@/store/index'
export default defineComponent({
	components: {
		MenuFoldOutlined,
		MenuUnfoldOutlined,
		PieChartOutlined,
		MailOutlined,
		DesktopOutlined,
		InboxOutlined,
		AppstoreOutlined,
	},
    props: ["isOpen"],
	setup() {
		let store=useStore()
		const state = reactive({
			collapsed: false,
			selectedKeys: ['1'],
			openKeys: ['sub1'],
			preOpenKeys: ['sub1'],
		});
		// const menuList=computed(()=>store.state.userInfos.menuList)
		onMounted(()=>{
			console.log(store.state.userInfos.userInfos)
		})
		watch(
			() => state.openKeys,
			(_val, oldVal) => {
				state.preOpenKeys = oldVal;
			}
		);
		const toggleCollapsed = () => {
			state.collapsed = !state.collapsed;
			state.openKeys = state.collapsed ? [] : state.preOpenKeys;
		};

		return {
			...toRefs(state),
			toggleCollapsed,
		};
	},
});
</script>
<style lang="scss" scoped>
.company-logo{
    width: 100%;
    height: 7vh;
    display: flex;
    color: #fff;
    font-weight: 500;
    font-size: 18px;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background: rgb(24,144,255);
}
</style>
