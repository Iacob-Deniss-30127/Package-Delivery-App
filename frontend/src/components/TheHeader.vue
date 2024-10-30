<template>
  <header class="header">
    <div><h1 class="header-title">Welcome to the main page</h1></div>
    <nav class="header-nav">
      <div class="input-container" v-if="showInput">
        <input type="text" placeholder="Search for a courier.." />
      </div>
    </nav>
    <nav class="header-nav">
      <router-link to="/" class="third-column">Profile</router-link>
    </nav>
  </header>
</template>

<script setup>
import { computed } from "vue";
import { useRoute } from "vue-router";
const route = useRoute();

const showInput = computed(() => {
  return route.name === "couriers-table";
});
</script>

<style scoped>
body,
html {
  margin: 0;
  padding: 0;
}
a {
  background-color: #222;
}
.header {
  background-color: #222; /* Dark background */
  color: #f5f5f5; /* Light text color */
  padding: 1rem 2rem;
  display: grid;
  grid-template-columns: 1fr auto 1fr;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3);
  position: fixed;
  width: 100%;

  top: 0;
  z-index: 2;
}

/* Header Logo or Title */
.header-title {
  background-color: #222;
  font-size: 1.5rem;
  font-weight: bold;
  color: #f5f5f5;
  margin: 0;
}

/* Navigation Links */
.header-nav {
  background-color: #222;
  padding-right: 100px;
  text-align: end;
}

.header-nav a {
  color: #f5f5f5;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.2s;
  grid-column: 3; /* Place the profile link in the third column */
  justify-self: end; /* Align profile link to the end */
}

.header-nav a:hover {
  color: #1e90ff; /* Light blue highlight on hover */
}

.input-container {
  flex: 1; /* Allow the container to grow and take available space */
  display: flex;
  background-color: #222;
  grid-column: 2; /* Place the input in the second column */
  justify-content: center; /* Center the input horizontally */
}
input[type="text"] {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 300px; /* Set a fixed width for the input */
}
</style>
