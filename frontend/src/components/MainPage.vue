<template>
  <div class="main-content"></div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

function goToCouriers() {
  router.push({ name: "couriers-table" });
}

const couriers = ref({
  id: String,
});
</script>

<style>
* {
  background-color: #111;
  color: white;
}

.main-content {
  margin-left: 250px; /* Space for sidebar */
  padding-top: 4rem; /* Offset for header height */
  padding: 2rem;
  background-color: #111;
  color: #f5f5f5;
  min-height: 100vh; /* Ensure it covers full height */
  overflow-y: auto; /* Allow scrolling if content exceeds viewport */
}
</style>
