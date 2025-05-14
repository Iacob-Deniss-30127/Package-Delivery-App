<template>
  <div class="couriers-page">
    <div class="input-table">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search for a courier by ID.."
      />
      <button class="search-button" @click="searchCourier">Search</button>
    </div>
    <div class="create-courier-form">
      <button class="search-button" @click="toggleCreateForm">
        Create new courier
      </button>
      <CreateCourierForm v-if="showCreateForm" />
    </div>
    <div class="courier-table">
      <CourierCard
        v-for="courier in couriers"
        :key="courier.id"
        :courier="courier"
        class="courier-row"
        @selectCourier="fetchCourierPackages"
      />
    </div>
    <div v-if="courierPackages.length > 0">
      <h2 class="table-title">Packages for Selected Courier</h2>
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date</th>
            <th>Address</th>
            <th>Amount</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="packageItem in courierPackages" :key="packageItem.id">
            <td>{{ packageItem.id }}</td>
            <td>{{ packageItem.packageName }}</td>
            <td>{{ packageItem.createdOn }}</td>
            <td>{{ packageItem.deliveryAddress }}</td>
            <td>{{ packageItem.payOnDelivery }}</td>
            <td>{{ packageItem.status }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup lang="ts">
import axios from "axios";
import { onMounted, ref } from "vue";
import CourierCard from "@/UI/CourierCard.vue";
import CreateCourierForm from "@/UI/CreateCourierForm.vue";

const couriers = ref<CourierEntity[]>([]);
const courierPackages = ref<PackageEntity[]>([]);
const searchQuery = ref<number | null>(null);
const showCreateForm = ref(false);

const toggleCreateForm = () => {
  showCreateForm.value = !showCreateForm.value;
};

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

const fetchCourierPackages = async (courierId: number) => {
  try {
    console.log("The courier id is : ", courierId);
    const response = await axios.get(
      `http://localhost:8083/api/packages/for/${courierId}`
    );
    courierPackages.value = response.data;
  } catch (error) {
    console.error("Error fetching packages", error);
  }
};

const searchCourier = async () => {
  if (searchQuery.value) {
    try {
      const response = await axios.get(
        `http://localhost:8083/api/couriers/${searchQuery.value}`
      );
      if (response.data) {
        couriers.value = [response.data]; // Show only the matched courier
      }
    } catch (error) {
      console.error("Error fetching courier by ID", error);
    }
  } else {
    fetchAllCouriers();
  }
};

onMounted(() => {
  fetchAllCouriers();
});
</script>

<style scoped>
.couriers-page {
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
  min-height: 100vh;
  padding-top: 80px; /* Adjust this based on your header height */
}
.courier-table {
  margin-top: 100px;
  display: grid;
  width: 100%;
  grid-template-columns: repeat(auto-fit, 15.5rem);
  justify-content: center;
}

div {
  font-size: 25px;
}

.input-table {
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 20px auto;
  width: 100%;
  max-width: 500px;
  gap: 20px;
}
.search-input {
  width: 300px;
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  margin-right: 10px;
}

.search-button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.search-button:hover {
  background-color: #0056b3;
}

table {
  margin-left: 300px;
  flex-direction: column;
  font-family: arial, sans-serif;
  border-collapse: collapse;
  max-width: max-content;
  max-width: 80%; /* Limited the table's width */
}

td,
th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

.table-title {
  text-align: center;
  font-size: 25px;
}

form {
  margin-left: 20px;
}
.add-package-button {
  margin: 10px 0;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 8px; /* Adds spacing between label and input */
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input:focus {
  outline: none;
  border-color: #007bff;
}

.create-courier-form {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
