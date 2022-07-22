import Vue from "vue";
import Router from "vue-router";
import Menu from "@/components/shared/Menu";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Menu",
      component: Menu,
      children: [
        {
          path: "/registrar-proveedor",
          component: () => import("@/components/RegistrarProveedor")
        },
        {
          path: "/listar-proveedor",
          component: () => import("@/components/ListarProveedor")
        }
      ]
    }
  ]
});
