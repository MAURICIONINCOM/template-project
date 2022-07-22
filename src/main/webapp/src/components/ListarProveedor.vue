<template>
  <div id="search">
    <v-card elevation="1">
      <v-card-text
        id="search-title"
        class="pa-1"
        v-text="'Listado de proveedores'"
      ></v-card-text>
      <v-row align="center">
        <v-col>
          <div v-if="items != null">
            <v-data-table
              :headers="headers"
              :items="items"
              :search="search"
              :page.sync="page"
              :items-per-page="itemsPerPage"
              class="elevation-3"
              hide-default-footer
              @page-count="pageCount = $event"
              @pagination="doSomething"
            >
              <template v-slot:[`item.index`]="{ index }">
                {{ index + page * itemsPerPage - (itemsPerPage - 1) }}
              </template>

              <template v-slot:[`item.modificar`]="{ item }">
                <v-btn
                  class="pa-1"
                  outlined
                  color="success"
                  rounded
                  small
                  @click="accionModificar(item)"
                  >Modificar
                </v-btn>
              </template>
              <template v-slot:[`item.eliminar`]="{ item }">
                <v-btn
                  class="pa-1"
                  outlined
                  color="primary"
                  rounded
                  small
                  @click="accionEliminar(item)"
                  >Eliminar
                </v-btn>
              </template>
            </v-data-table>
            <div class="text-center pt-2">
              <v-container>
                <v-row justify="center">
                  <v-col cols="8">
                    <v-container class="max-width">
                      <v-pagination
                        v-model="page"
                        :length="pageCount"
                      ></v-pagination>
                    </v-container>
                  </v-col>
                </v-row>
              </v-container>
            </div>
          </div>
        </v-col>
      </v-row>
    </v-card>
    <br />
    <eliminarCliente
      :show.sync="showEliminar"
      :item="itemEliminar"
    ></eliminarCliente>
    <modificarCliente
      :show.sync="showModificar"
      :item="itemModificar"
    ></modificarCliente>
  </div>
</template>
<script>
import clienteService from "../services/proveedor-service";
import eliminarCliente from "../components/shared/EliminarCliente";
import modificarCliente from "../components/shared/ModificarCliente";

export default {
  components: {
    eliminarCliente,
    modificarCliente
  },
  data() {
    return {
      page: 1,
      pageCount: 0,
      itemsPerPage: 15,
      search: "",
      pagination: {},
      items: [],
      headers: [
        {
          text: "Nro",
          value: "index",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Nombre",
          value: "nombre",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Direccion",
          value: "direccion",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Telefono",
          value: "telefono",
          width: "1%",
          align: "center",
          sortable: false
        },
        /*{
          text: "Nit",
          value: "nit",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Celular",
          value: "celular",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Fecha Creacion",
          value: "fechaCreacion",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Estado",
          value: "estado",
          width: "1%",
          align: "center",
          sortable: false
        },*/
        {
          text: "Accion",
          value: "modificar",
          width: "1%",
          align: "center",
          sortable: false
        },
        {
          text: "Accion",
          value: "eliminar",
          width: "1%",
          align: "center",
          sortable: false
        }
      ],
      showEliminar: false,
      itemEliminar: "",
      itemCuenta: "",

      showModificar: false,
      itemModificar: ""
    };
  },
  created() {
    clienteService.getListarService().then(result => {
      this.items = result.data.data;
      //console.log(result);
    });
  },
  methods: {
    doSomething(v) {
      //console.log("pagination", v);
      this.pagination = v;
    },
    accionEliminar(item) {
      this.showEliminar = true;
      this.itemEliminar = item;
      /*cuentaService.getListarCuentasByIdCliente(item.id).then(result => {
        console.log(result);
        this.itemCuenta = result.data.data;
      });*/
    },
    accionModificar(item) {
      this.showModificar = true;
      this.itemModificar = item;
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
