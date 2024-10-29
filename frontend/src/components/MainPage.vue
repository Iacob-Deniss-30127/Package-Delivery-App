<template>
  <h1>Welcome to the main page</h1>
  <button @click="goToCouriers">All couriers</button>
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
