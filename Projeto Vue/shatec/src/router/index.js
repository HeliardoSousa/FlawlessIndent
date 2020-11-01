import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Produto from "../views/Produto.vue";
import UserEdit from "../views/UserEdit.vue";
import Buscar from "../views/Buscar.vue";
import ProdEdit from "../views/ProdEdit"
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Login.vue')
    }
  },
  {
    path: '/register',
    name: 'Register',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/Register.vue')
    }
  },
  {
    path: '/user',
    name: 'User',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/User.vue')
    }
  },
  {
    path: "/user/edit/:id",
    name: "UserEdit",
    component: UserEdit,
    props: true,
  },
  {
    path: "/user/editProd/:id",
    name: "ProdutoEdit",
    component: ProdEdit,
    props: true,
  },
  {
    path: "/produto/:id",
    name: "Produto",
    component: Produto,
    props: true,
  },

  {
    path: "/buscar/:categoria",
    name: "Buscar",
    component: Buscar,
    props: true,
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
