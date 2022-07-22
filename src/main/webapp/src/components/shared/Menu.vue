<template>
  <v-app>
    <v-main>
      <v-container>
        <v-row>
          <v-col align="center">
            <v-btn color="primary" outlined rounded @click="registrarProveedor()">
              Registrar cliente
            </v-btn>
          </v-col>
            <v-col align="center">
            <v-btn color="primary" outlined rounded @click="listarProveedores()">
              Listado de clientes
            </v-btn>
          </v-col>
        </v-row>
        <v-row>
          <v-responsive max-width="100%" class="pa-5">
            <router-view />
          </v-responsive>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import RegistrarCliente from "../RegistrarProveedor";
import ListarCliente from "../ListarProveedor.vue";

export default {
  name: "Menu",
  components: {
    RegistrarCliente,
    ListarCliente
  },
  methods: {
    registrarProveedor() {
      this.$router.push({ path: "/registrar-proveedor" }).catch(() => {});
    },
    listarProveedores() {
      this.$router.push({ path: "/listar-proveedor" }).catch(() => {});
    },
  }
};
</script>
