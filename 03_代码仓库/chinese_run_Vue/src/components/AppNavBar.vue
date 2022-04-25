<template>
	<div class="app-container">
		<a-tabs v-model:activeKey="activeKey" @change="handleTabChange" style="margin-top: 10px" hide-add type="editable-card" @edit="onEdit">
			<a-tab-pane v-for="pane in panes" :key="pane.key" :tab="pane.title" :closable="pane.closable"> </a-tab-pane>
		</a-tabs>
	</div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs, ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { Session } from '/@/utils/storage';
import lodash from 'lodash';
export default defineComponent({
	setup() {
		// 获取路由
		const router = useRouter();
		// 对于拿取到的数据都根据ID去重
		const tmpArr = lodash.uniqBy(Session.get('tabviews'), 'key');
		const panes = ref<{ title: string; content: string; key: string; closable?: boolean }[]>(
			new Array(tmpArr.length).fill(null).map((_, index) => {
				console.log(tmpArr)
				const id=index
				console.log(index)
				return { title: `${tmpArr[id].title}`, content: `${tmpArr[id].content}`, key: `${tmpArr[id].key}`};
			})
		);
		const activeKey = ref(panes.value[0].key);
		// 在路由加载之前执行的操作
		router.afterEach((to) => {
			/**
			 * 当路由发生改变的时候，获取当前标签数组数据，并且将新的数据push到标签数组数据当中去
			 */
			let array = Session.get('tabviews');
			const tmp = {
				title: to.meta.title,
				content: to.name,
				key: to.fullPath
			};
			if (to.name === 'login') {
				return;
			} else {
				array.push(tmp);
			}
			/**
			 * 将选择的菜单放到store里面去
			 */
			Session.set('menuTab', lodash.uniqBy(array, 'value'));
			add(tmp.title,tmp.content,tmp.key)
			
		});
		// 设置点击close按钮的显示
		const onEdit = (targetKey:string) => {
			remove(targetKey);
		};
		// 设置删除一个标签
		const remove = (targetKey:string) => {
			let lastIndex = 0;
			panes.value.forEach((pane, i) => {
				if (pane.key === targetKey) {
					lastIndex = i - 1;
				}
			});
			panes.value = panes.value.filter((pane) => pane.key !== targetKey);
			if (panes.value.length && activeKey.value === targetKey) {
				if (lastIndex >= 0) {
					activeKey.value = panes.value[lastIndex].key;
				} else {
					activeKey.value = panes.value[0].key;
				}
			}
			router.push('/')
		};
		const add = (title:any,content:any,key:any) => {
			if(key=='/index'){
				return 
			}
			activeKey.value = key;
			panes.value.push({
				title: title,
				content: content,
				key: activeKey.value,
			});
		};
		const handleTabChange = (activeKey:any) => {
			router.push(activeKey)
		};
		return {
			handleTabChange,
			remove,
			onEdit,
			panes,
			activeKey
		};
	},
});
</script>
<style lang="scss" scoped>
.app-container {
	box-sizing: border-box;
	padding: 0 10px;
}
.ant-tabs {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	color: rgba(0, 0, 0, 0.85);
	font-size: 14px;
	font-variant: tabular-nums;
	line-height: 0.75;
	list-style: none;
	font-feature-settings: 'tnum';
	display: flex;
	overflow: hidden;
}
</style>
