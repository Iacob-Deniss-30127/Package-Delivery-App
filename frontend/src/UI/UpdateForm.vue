<template>
  <div class="update-form">
    <h3>Update Package</h3>
    <form @submit.prevent="submitUpdate">
      <div>
        <label for="id">Package ID:</label>
        <input type="number" v-model="packageData.id" required />
      </div>
      <div>
        <label for="packageName">Name:</label>
        <input type="text" v-model="packageData.packageName" />
      </div>
      <div>
        <label for="deliveryAddress">Address:</label>
        <input type="text" v-model="packageData.deliveryAddress" />
      </div>
      <div>
        <label for="status">Status:</label>
        <select v-model="packageData.status">
          <option value="new">New</option>
          <option value="pending">Pending</option>
          <option value="delivered">Delivered</option>
        </select>
      </div>
      <div>
        <label for="courierId">Courier ID:</label>
        <input type="number" v-model="packageData.courierId" />
      </div>
      <button class="submit-button">Update</button>
    </form>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";
import axios from "axios";
const props = defineProps({
  onUpdate: Function,
});

const packageData = ref({
  id: "",
  packageName: "",
  deliveryAddress: "",
  status: "new",
});

const submitUpdate = async () => {
  try {
    const updatedPackageData = {
      id: packageData.value.id,
      packageName: packageData.value.packageName,
      deliveryAddress: packageData.value.deliveryAddress,
      status: packageData.value.status,
    };

    const response = await axios.patch(
      `http://localhost:8083/api/packages/update/${packageData.value.id}`,
      updatedPackageData,
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
  } catch (error) {
    console.error("Cannot update the package", error);
  }
};
</script>

<style scoped>
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

.submit-button {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}
.submit-button:hover {
  background-color: #0056b3;
}

.styled-dropdown {
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #ccc;
  background-color: #f0f0f0;
  font-size: 14px;
  width: 100%;
}

.styled-dropdown:focus {
  outline: none;
  border-color: #007bff;
  background-color: #e9f1ff;
}
</style>
