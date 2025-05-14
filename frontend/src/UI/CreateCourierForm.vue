<template>
  <div class="create-courier-form">
    <form @submit.prevent="submitCourier">
      <div>
        <label for="name">Courier Name</label>
        <input type="text" v-model="courierData.name" required />
      </div>
      <div>
        <label for="email">Courier Email</label>
        <input type="email" v-model="courierData.email" required />
      </div>
      <div>
        <label for="isManager">Is Manager</label>
        <input
          type="text"
          v-model="courierData.isManager"
          placeholder="Enter 'true' or 'false'"
        />
      </div>

      <button class="create-button">Create Courier</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";

const courierData = ref({
  name: "",
  email: "",
  isManager: "",
});

const submitCourier = async () => {
  try {
    const newCourierData = {
      name: courierData.value.name,
      email: courierData.value.email,
      isManager: courierData.value.isManager,
    };
    const response = await axios.post(
      `http://localhost:8083/api/couriers/create`,
      newCourierData,
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    console.log("Courier created successfully:", response.data);
  } catch (error) {
    console.error("Cannot create courier", error);
  }
};
</script>

<style scoped>
.create-button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.create-button:hover {
  background-color: #0056b3;
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
</style>
