<template>
  <div id="app">
    <img alt="Bitcoin logo" src="./assets/Bitcoinlogo.png">
    <CalculoMedia msg="Buena"/>
  </div>
</template>

<script>
import CalculoMedia from './components/CalculoMedia.vue'

export default {
  name: 'App',
  components: {
    CalculoMedia
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
