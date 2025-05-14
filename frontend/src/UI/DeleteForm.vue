<template>
  <form @submit.prevent="deletePackage">
    <div>
      <label for="deletePackage">Type the id of the package:</label>
      <input id="deletePackage" type="number" v-model="packageId" required />
    </div>
    <button class="submit-button">Submit</button>
  </form>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
const packageId = ref(0);

const deletePackage = async () => {
  try {
    const response = await axios.delete(
      `http://localhost:8083/api/packages/delete?id=${packageId.value}`
    );
    console.log("Package deleted succesfully");
  } catch (error) {
    console.error("Could not delete the package", error);
  }
};
</script>

<style scoped>
form {
  margin-left: 20px;
}

.submit-button {
  padding: 8px 16px;
  background-color: #d9534f;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
}

.submit-button:hover {
  background-color: #c9302c;
}

input {
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
