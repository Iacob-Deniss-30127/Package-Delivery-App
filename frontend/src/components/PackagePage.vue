<template>
  <section class="main-page">
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Date</th>
          <th>Address</th>
          <th>Amount</th>
          <th>Status</th>
          <th>Courier</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="packages in allPackages" :key="packages.id">
          <td>{{ packages.id }}</td>
          <td>{{ packages.packageName }}</td>
          <td>{{ packages.createdOn }}</td>
          <td>{{ packages.deliveryAddress }}</td>
          <td>{{ packages.payOnDelivery }}</td>
          <td>{{ packages.status }}</td>
          <td>{{ packages.courierId }}</td>
        </tr>
      </tbody>
    </table>
    <div class="button-container">
      <button @click="toggleForm" v-if="!showDeleteForm && !showUpdateForm">
        Add a package
      </button>
      <PackageForm v-if="showForm" />
      <button
        class="delete-button"
        v-if="!showForm && !showUpdateForm"
        @click="toggleDeleteForm"
      >
        Delete a package
      </button>
      <DeleteForm v-if="showDeleteForm" />
      <button
        class="update-button"
        v-if="!showForm && !showDeleteForm"
        @click="toggleUpdateForm"
      >
        Update package
      </button>
      <UpdateForm v-if="showUpdateForm" />
    </div>
  </section>
</template>

<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import PackageForm from "@/UI/PackageForm.vue";
import DeleteForm from "@/UI/DeleteForm.vue";
import UpdateForm from "@/UI/UpdateForm.vue";

const allPackages = ref([]);
const showForm = ref(false);
const showDeleteForm = ref(false);
const showUpdateForm = ref(false);

const fetchAllPackages = async () => {
  try {
    const response = await axios.get(`http://localhost:8083/api/packages`);
    if (response.data) {
      allPackages.value = response.data;
      console.log(allPackages.value);
    }
  } catch (error) {
    console.error("Error for packages, ", error);
  }
};

const toggleForm = () => {
  showForm.value = !showForm.value;
};

const toggleDeleteForm = () => {
  showDeleteForm.value = !showDeleteForm.value;
};

const toggleUpdateForm = () => {
  showUpdateForm.value = !showUpdateForm.value;
};

onMounted(() => {
  fetchAllPackages();
});
</script>

<style scoped>
.main-page {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 50vh;
  margin-top: 100px;
}

.package-row {
  display: contents; /* Allows children to align in the grid layout */
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  max-width: max-content;
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

button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-left: 20px;
}

.delete-button {
  background-color: #d9534f;
}

.update-button {
  background-color: #28a745;
}

.button-container {
  display: flex;
  flex-direction: column; /* Stack buttons vertically */
  gap: 10px; /* Space between buttons */
  margin-top: 20px; /* Optional: Space above the button container */
}
</style>
