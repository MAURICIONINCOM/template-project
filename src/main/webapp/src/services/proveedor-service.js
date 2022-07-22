import axios from "axios";
const baseUrl = process.env.ROOT_API;
export default {
  postRegistrarService(request) {
    return axios.post(baseUrl + "cliente/add", request);
  },

  getListarService() {
    return axios.get(baseUrl + "cliente/list");
  },

  eliminarService(id) {
    return axios.delete(baseUrl + "cliente/delete/" + id);
  },

  putModificarService(id, request) {
    return axios.put(baseUrl + "cliente/update/" + id, request);
  },

  getObtenerService(id) {
    return axios.get(baseUrl + "cliente/" + id);
  }
};
