<template>
	<div class="company-logo">
		<span v-if="isOpen">华润</span>
		<div v-else>
			<img src="/logo.png" style="width: 30px; height: 30px" alt="Logo chinese_run" />
			<span style="margin-left: 0.5rem">华润物流</span>
		</div>
	</div>
	<a-menu v-model:openKeys="openKeys" v-model:selectedKeys="selectedKeys" mode="inline" :inline-collapsed="isOpen">
		<div v-for="(item, index) in menuList" :key="index">
			<a-menu-item :key="item.id" @click="handleMenuChange(item.targetUrl)" v-if="item.childs.length == 0">
				<template #icon>
					<Icon :icon="'AppstoreOutlined'" />
				</template>
				<span>{{ item.name }}</span>
			</a-menu-item>
			<a-sub-menu :key="item.id">
				<template #icon>
					<Icon :icon="'AppstoreOutlined'" />
				</template>
				<template #title><span  v-show="!isOpen">{{ item.name }}</span></template>
				<a-menu-item v-for="e in item.childs" @click="handleMenuChange(e)" :key="e.id">
					<template #icon>
						<Icon :icon="'AppstoreOutlined'" />
					</template>
					<span>{{ e.name }}</span>
				</a-menu-item>
			</a-sub-menu>
		</div>
	</a-menu>
</template>
<script lang="ts">
import { computed, defineComponent, onMounted, reactive, toRefs, watch } from 'vue';
import { Session } from '/@/utils/storage';
import { Icon } from '/@/utils/antdIcon';
import router from '/@/router/index'
export default defineComponent({
	components: {
		Icon,
	},
	props: ['isOpen'],
	setup() {
		const menuList = computed(() => Session.get('MenuList'));
		const state = reactive({
			collapsed: false,
			selectedKeys: ['1'],
			openKeys: ['sub1'],
			preOpenKeys: ['sub1'],
		});
		// const menuList=computed(()=>store.state.userInfos.menuList)
		onMounted(() => {});
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
		const handleMenuChange = (e:any) => {
			console.log(e)
			router.push(e.targetUrl)
		};
		return {
			...toRefs(state),
			toggleCollapsed,
			handleMenuChange,
			menuList,
		};
	},
});
</script>
<style lang="scss" scoped>
.company-logo {
	width: 100%;
	height: 7vh;
	display: flex;
	color: #fff;
	font-weight: 500;
	font-size: 18px;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background: rgb(24, 144, 255);
}
</style>
