<template>
    <a-card class="activity-container">
        这里是首页
    </a-card>
</template>
<script>
import { defineComponent, reactive, toRefs } from 'vue'

export default defineComponent({
    setup() {
        const state=reactive({

        })
        return {
            ...toRefs(state)
        }
    },
})
</script>