<template>
  <form @submit.prevent="handleSubmit">
    <div>
      <label for="packageName">Package Name:</label>
      <input id="packageName" v-model="formData.packageName" required />
    </div>
    <div>
      <label for="deliveryAddress">Delivery Address:</label>
      <input id="deliveryAddress" v-model="formData.deliveryAddress" required />
    </div>
    <div>
      <label for="payOnDelivery">Pay on Delivery:</label>
      <input
        id="payOnDelivery"
        type="number"
        v-model="formData.payOnDelivery"
        min="0"
      />
    </div>
    <button class="submit-button">Submit</button>
  </form>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";

const formData = ref({
  packageName: "",
  deliveryAddress: "",
  payOnDelivery: 0,
  status: "NEW",
});

const handleSubmit = async () => {
  try {
    const response = await axios.post(
      `http://localhost:8083/api/packages/create?courierId=1`,
      formData.value
    );
    console.log("Package added succesfully");
    formData.value = {
      packageName: "",
      deliveryAddress: "",
      payOnDelivery: 0,
    };
  } catch (error) {
    console.error("Error adding package", error);
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
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 10px;
}

.submit-button:hover {
  background-color: #0056b3;
}
</style>
