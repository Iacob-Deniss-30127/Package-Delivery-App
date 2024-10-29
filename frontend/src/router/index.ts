import { createRouter, createWebHistory } from "vue-router";
import CouriersTable from "@/components/CouriersTable.vue";
import MainPage from "@/components/MainPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      name: "main",
      path: "/",
      component: MainPage,
    },
    {
      name: "couriers-table",
      path: "/couriers-table",
      component: CouriersTable,
    },
  ],
});

export default router;
