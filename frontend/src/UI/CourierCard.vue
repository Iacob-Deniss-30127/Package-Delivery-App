<template>
  <section class="card">
    <h3 class="courier-name">
      <slot></slot>
    </h3>
  </section>
</template>

<style scoped>
.card {
  background-color: #333; /* Dark background */
  color: #f5f5f5; /* Light text for contrast */
  padding: 1rem;
  border-radius: 8px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
  max-width: 200px; /* Adjust size as needed */
  cursor: pointer;
  transition: transform 0.2s, box-shadow 0.2s;
}

.card:hover {
  transform: translateY(-5px);
  box-shadow: 0px 6px 12px rgba(0, 0, 0, 0.3),
    0px 0px 15px rgba(16, 72, 129, 0.6); /* Blue glow */
}

.card a {
  text-decoration: none;
  color: inherit;
}

.courier-name {
  background-color: inherit;
  font-size: 1.2rem;
  font-weight: 500;
  text-align: center;
  margin: 0;
}
</style>
