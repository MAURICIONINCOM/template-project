<template>
  <v-dialog v-model="show" width="900" scrollable persistent>
    <v-container class="white" dense>
      <v-card class="text-left">
        <v-card-title class="texts pa-1 ma-2">
          Eliminar
        </v-card-title>
        <!--<v-card-text class="titles pa-1 ma-2">
          CLIENTE: {{ item.nombre }}<br />
          DIRECCION: {{ item.direccion }}<br />
          NIT: {{ item.nit }}<br />
          CELULAR: {{ item.celular }}<br />
          FECHA DE CREACION: {{ item.fechaCreacion }}<br />
          ESTADO: {{ item.estado }}<br />
          <v-divider></v-divider>
        </v-card-text>-->
        <v-card-text class="titles pa-1 ma-2">
          CLIENTE: {{ item.nombre }}<br />
          DIRECCION: {{ item.direccion }}<br />
          TELEFONO: {{ item.telefono }}<br />          
          <v-divider></v-divider>
        </v-card-text>
        <br />
      </v-card>
      <v-card class="text-right">
        <v-btn outlined color="red" v-if="showBoton" @click="deleteProveedor()">
          Eliminar
        </v-btn>
        <v-btn class="ma-3" outlined color="primary" @click="close()">
          Salir
        </v-btn>
      </v-card>
    </v-container>
  </v-dialog>
</template>
<script>
import clienteService from "../../services/proveedor-service";
import { createToastInterface } from "vue-toastification";
import "vue-toastification/dist/index.css";

const pluginOptions = { timeout: 4000 };
const toast = createToastInterface(pluginOptions);

export default {
  props: ["show", "item"],
  data() {
    return {
      showBoton: true
    };
  },
  methods: {
    deleteProveedor() {
      clienteService.eliminarService(this.item.id).then(result => {
        toast.info(this.item.nombre + "\n" + "Proveedor eliminado");
        this.showBoton = false;
      });
    },

    close() {
      location.reload();
      this.$emit("update:show", false);
    }
  }
};
</script>
