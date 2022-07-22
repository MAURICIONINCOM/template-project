<template>
  <v-app id="App">
    <div style="width:10%;position:relative;">
      <v-img :src="require('../src/assets/lafar.png')"></v-img>     
    </div>
     <v-card-title class="pa-1 mb-2 justify-center primary--text text-h7">
        Gestion de clientes
      </v-card-title>          
    <router-view></router-view>       
  </v-app>
</template>
<script>
export default {
  name: "App",  
};
</script>
