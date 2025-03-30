import {createRouter, createWebHistory} from 'vue-router'
import chooseFlightView from '@/views/chooseFlightView.vue'
import BookView from "@/views/BookView.vue";



const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: chooseFlightView,
        },
        {
            path: '/bookFlight',
            name: 'book',
            component: BookView,
        },

    ],
})

export default router