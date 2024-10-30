<template>
  <TheHeader></TheHeader>
  <TheSidebar></TheSidebar>
  <router-view></router-view>
</template>

<script setup lang="ts">
import TheHeader from "./components/TheHeader.vue";
import TheSidebar from "./UI/TheSidebar.vue";
</script>

<style>
* {
  font-family: sans-serif;
}
body,
html {
  margin: 0;
  padding: 0;
}
</style>
