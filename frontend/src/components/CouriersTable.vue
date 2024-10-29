<template>
  <div class="courier-table">
    <div class="first-row">
      <div>Id</div>
      <div>Name</div>
      <div>Email</div>
      <div>Is Manager</div>
      <div>Manager Id</div>
    </div>

    <div v-for="courier in couriers" :key="courier.id" class="courier-row">
      <div>{{ courier.id }}</div>
      <div>{{ courier.name }}</div>
      <div>{{ courier.email }}</div>
      <div>{{ courier.isManager }}</div>
      <div>{{ courier.manager ? courier.manager.id : "None" }}</div>
    </div>
  </div>
</template>

<script setup lang="ts">
import axios from "axios";
import { onMounted, ref } from "vue";

const couriers = ref<CourierEntity[]>([]);

const fetchAllCouriers = async () => {
  try {
    const response = await axios.get("http://localhost:8083/api/couriers");
    if (response.data) {
      couriers.value = response.data;
    }
  } catch (error) {
    console.error("Error fetching the couriers", error);
  }
};

onMounted(() => {
  fetchAllCouriers();
});
</script>

<style scoped>
.courier-table {
  display: grid;
  grid-template-columns: 20% 20% 20% 20% 20%;
}

div {
  font-size: 25px;
}
</style>
