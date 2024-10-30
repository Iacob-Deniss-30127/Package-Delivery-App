<template>
  <div class="sidebar">
    <router-link to="/" class="sidebar-item">Home</router-link>
    <router-link :to="{ name: 'couriers-table' }" class="sidebar-item"
      >Couriers</router-link
    >
    <a href="/about" class="sidebar-item">About</a>
  </div>
</template>

<script></script>

<style scoped>
.sidebar {
  background-color: #222; /* Dark background */
  color: #f5f5f5; /* Light text */
  width: 250px;
  height: 100vh;
  padding-top: 5rem;
  position: fixed;
  display: flex;
  flex-direction: column;
  box-shadow: 4px 0 8px rgba(0, 0, 0, 0.3);
  top: 0;
  left: 0;
  z-index: 1; /* Sidebar sits under header */
}

/* Header Container */
.header {
  background-color: #222;
  color: #f5f5f5;
  padding: 1rem 2rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3);
  position: fixed;
  width: 100%; /* Full width to cover sidebar */
  top: 0;
  z-index: 2; /* Ensures header covers sidebar */
}

/* Sidebar Item */
.sidebar-item {
  padding: 1rem 2rem;
  font-size: 1rem;
  font-weight: 500;
  color: #f5f5f5;
  transition: background-color 0.3s, color 0.3s;
  text-decoration: none;
  display: block;
}

/* Hover and Active Effect */
.sidebar-item:hover,
.sidebar-item.active {
  background-color: #1e90ff;
  color: #222;
  border-left: 4px solid #1e90ff;
}
a {
  background-color: #222;
}

.router-link-active {
  background-color: #1e90ff; /* Highlight color */
  color: #222; /* Text color for active state */
  border-left: 4px solid #1e90ff; /* Left border for visual effect */
}
</style>
