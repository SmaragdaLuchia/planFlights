import {createRouter, createWebHistory} from 'vue-router'
import flightBook from '../views/chooseFlightView.vue'

const routes = [
    {
        path: '/',
        component: flightBook
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router