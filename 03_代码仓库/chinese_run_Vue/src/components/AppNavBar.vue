<template>
	<div class="app-container">
		<a-tabs v-model:activeKey="activeKey" style="margin-top:10px;" hide-add type="editable-card" @edit="onEdit">
			<a-tab-pane v-for="pane in panes" :key="pane.key" :tab="pane.title" :closable="pane.closable">
			</a-tab-pane>
		</a-tabs>
	</div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs, ref } from 'vue';

export default defineComponent({
	setup() {
		const panes = ref<{ title: string; content: string; key: string; closable?: boolean }[]>(
			new Array(2).fill(null).map((_, index) => {
				const id = String(index + 1);
				return { title: `页面 ${id}`, content: `Content of Tab Pane ${id}`, key: id };
			})
		);
        // 设置默认选中的tabs
		const activeKey = ref(panes.value[0].key);
        // 设置状态变量
		const state = reactive({});
        // 设置点击close按钮的显示
		const onEdit = (targetKey: string) => {
			remove(targetKey);
		};
        // 设置删除一个标签
		const remove = (targetKey: string) => {
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
		};
		return {
			...toRefs(state),
			panes,
			remove,
            onEdit,
			activeKey,
		};
	},
});
</script>
<style lang="scss" scoped>
.app-container{
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
    line-height: .75;
    list-style: none;
    font-feature-settings: 'tnum';
    display: flex;
    overflow: hidden;
}
</style>
