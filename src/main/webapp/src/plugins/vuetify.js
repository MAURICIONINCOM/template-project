import Vue from 'vue';
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
      options: {
        customProperties: true,
      },
      themes: {
        light: {
          primary: '#043166',
          secondary: '#009688',
          accent: '#F2F3F4',
          error: '#f44336',
          warning: '#ffc107',
          info: '#2196f3',
          success: '#4caf50',
          back_color:'#dcdcdc',
        },
      },
    },
  });
