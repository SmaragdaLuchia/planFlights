import {createRouter, createWebHistory} from 'vue-router'
import chooseFlightView from '@/views/chooseFlightView.vue'



const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: chooseFlightView,
        },
    ],
})

export default router