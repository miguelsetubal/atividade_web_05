import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Users from "../views/Funcs.vue";
import UserInsert from "../views/FuncInsert.vue";
import UserEdit from "../views/FuncEdit.vue";7
import FuncById from "../views/FuncByID.vue";
import FuncByCargo from "../views/FuncByCargo.vue";
import FuncByQtd from "../views/FuncByQtd.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    component: Home,
  },
  {
    path: "/",
    name: "Home",
    component: Home,
  }, 
  {
    path: "/users",
    name: "Users",
    component: Users,
  },
  {
    path: "/users/insert",
    name: "UserInsert",
    component: UserInsert,
  },
  {
    path: "/users/edit/:id",
    name: "UserEdit",
    component: UserEdit,
    props: true,
  },
  {
    path: "/users/:id",
    name: "FuncById",
    component: FuncById,
      
  },
  {
    path: "/cargo",
    name: "FuncByCargo",
    component: FuncByCargo,
      
  },
  {
    path: "/qtd",
    name: "FuncByQtd",
    component: FuncByQtd,
      
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
