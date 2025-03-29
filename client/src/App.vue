<template>
  <div id="app">
    <router-view></router-view> <!-- This is where pages will render -->
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
#app {
  text-align: center;
  margin-top: 20px;
}
</style>
