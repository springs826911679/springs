import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manage',
    component: ()=>import('../views/Manage.vue'),
    redirect:"/home",
    children:[
      {
        path: '/user', name: '用户管理', component: ()=>import('../views/User.vue'),
      },
      {
        path: '/home', name: '首页', component: ()=>import('../views/Home.vue'),
      },
      {
        path: '/person', name: '个人信息', component: ()=>import('../views/Person.vue'),
      },
      {
        path: '/lotteryDraw', name: '抽奖', component: ()=>import('../views/LotteryDraw.vue'),
      },
      {
        path: '/rewardList', name: '抽奖', component: ()=>import('../views/RewardList.vue'),
      },
      {
        path: '/personRewardList', name: '抽奖', component: ()=>import('../views/PersonRewardList.vue'),
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue'),
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register.vue'),
  },
  {
    path: '/person',
    name: 'Person',
    component: () => import('../views/Person.vue'),
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
