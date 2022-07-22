<template>
  <v-dialog v-model="show" width="900" scrollable persistent>
    <v-container class="white" dense>
      <v-card class="text-left">
        <v-card-title class="texts pa-1 ma-2">
          Modificar
        </v-card-title>
        <v-row align="center">
          <v-col>
            <v-text-field
              id="search-input"
              class="pa-3"
              label="Nombre del cliente"
              placeholder="Nombre del cliente"
              v-model="item.nombre"
              outlined
            ></v-text-field>
          </v-col>
          <v-col>
            <v-text-field
              id="search-input"
              class="pa-1"
              label="Direccion del cliente"
              placeholder="Direccion del cliente"
              v-model="item.direccion"
              outlined
            ></v-text-field>
          </v-col>
          <v-col>
            <v-text-field
              id="search-input"
              class="pa-3"
              label="Telefono del cliente"
              placeholder="telefono del cliente"
              v-model="item.telefono"
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
              v-model="item.celular"
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
                  v-model="item.fechaCreacion"
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
                v-model="item.fechaCreacion"
                @input="menuFecha = false"
              ></v-date-picker>
            </v-menu>
          </v-col>
          <v-col>
            <v-select
              :items="['ACTIVO', 'INACTIVO']"
              class="pa-3"
              label="Estado del proveedor"
              v-model="item.estado"
              outlined
            ></v-select>
          </v-col>
        </v-row>
        -->
        
      </v-card>
      <v-card class="text-right">
        <v-btn
          outlined
          color="green"
          v-if="showBoton"
          @click="ModificarProveedor()"
        >
          Modificar
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
      //menuFecha: false,
      showBoton: true,
      request: Object
    };
  },
  methods: {
    ModificarProveedor() {
      this.request = this.loadRequest();
      clienteService
        .putModificarService(this.item.id, this.request)
        .then(result => {
          toast.info(this.item.nombre + "\n" + result.data.message);
          this.showBoton = false;
        });
    },
    loadRequest() {
      return {
        nombre: this.item.nombre,
        direccion: this.item.direccion,
        telefono: this.item.telefono,
        /*nit: this.item.nit,
        celular: this.item.celular,
        fechaCreacion: this.item.fechaCreacion,
        estado: this.item.estado*/
      };
    },

    close() {
      location.reload();
      this.$emit("update:show", false);
    }
  }
};
</script>
