<template>
  <div id="search">
    <v-card elevation="1">
      <v-card-text
        id="search-title"
        class="pa-1"
        v-text="'Ingrese los datos del cliente'"
      ></v-card-text>
      <v-row align="center">
        <v-col>
          <v-text-field
            id="search-input"
            class="pa-3"
            label="Nombre del cliente"
            placeholder="Nombre del cliente"
            v-model="nombre"
            outlined
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            id="search-input"
            class="pa-3"
            label="Direccion del cliente"
            placeholder="Telefono del cliente"
            v-model="direccion"
            outlined
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            id="search-input"
            class="pa-3"
            label="Telefono del cliente"
            placeholder="Telefono del cliente"
            v-model="telefono"
            outlined
          ></v-text-field>
        </v-col>
      </v-row>
<!--
      <v-row>
        <v-col>
          <v-text-field
            id="search-input"
            class="pa-3"
            label="Celular del proveedor"
            placeholder="Celular del proveedor"
            v-model="celular"
            outlined
          ></v-text-field>
        </v-col>
       
        <v-col>
          <v-menu
            v-model="menuFecha"
            :close-on-content-click="false"
            transition="scale-transition"
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="fechaCreacion"
                label="Fecha de creacion"
                prepend-icon="mdi-calendar"
                class="pa-3"
                readonly
                outlined
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="fechaCreacion"
              @input="menuFecha = false"
            ></v-date-picker>
          </v-menu>
        </v-col>
        <v-col>
          <v-select
            :items="['ACTIVO', 'INACTIVO']"
            class="pa-3"
            label="Estado del proveedor"
            v-model="estado"
            outlined
          ></v-select>
        </v-col>
      </v-row>
-->
      <v-row align="center" justify="space-around">
        <v-col align="center">
          <v-btn id="search-button" v-on:click="registrar()">
            Registrar
          </v-btn>
        </v-col>
      </v-row>
    </v-card>
    <br />
  </div>
</template>

<script>
import clienteService from "../services/proveedor-service";
import { createToastInterface } from "vue-toastification";
import "vue-toastification/dist/index.css";

const pluginOptions = { timeout: 4000 };
const toast = createToastInterface(pluginOptions);

export default {
  name: "Search",
  data() {
    return {
      nombre: null,
      direccion: null,
      telefono: null,
      //nit:null,
      //celular: null,
      //fechaCreacion: null,
      //estado: null,
      //menuFecha: false,
      request: Object
    };
  },
  mounted() {
    //this.input.codeProcess = Vue.config.productionTip ? "" : "CP6RAUN3T23780";
  },
  methods: {
    registrar() {
      this.request = this.loadRequest();
      clienteService.postRegistrarService(this.request).then(result => {
        toast.success(
          result.data.data.nombre +
            "\n" +
            result.data.message
        );
        this.$router.push("/");
      });      
    },
    loadRequest() {
      return {
        nombre: this.nombre,
        direccion: this.direccion,
        telefono: this.telefono,
        //nit: this.nit,
        //celular: this.celular,
        //fechaCreacion: this.fechaCreacion,
        //estado: this.estado
      };
    }
  }
};
</script>
<style>
#search-title {
  font-size: 1em;
  background-color: #053266;
  color: white;
}
#search-input {
  background-color: white;
}
#search-button {
  margin-top: -20px;
  margin-right: 0px;
  margin-bottom: 10px;
  margin-left: 0px;
  font-size: 0.9em;
  background-color: #d4dce4;
  color: #053266;
  width: 85%;
}
</style>
