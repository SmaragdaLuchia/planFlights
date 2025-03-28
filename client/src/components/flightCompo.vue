<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  flight: {
    type: Object,
    required: true
  }
});

</script>

<template>
  <div class="container">
    <div class="flightBody">
      <p>{{ props.flight.duration }}</p>
      <p>{{ flight.airline}}</p>
      <p>{{ flight.destination }}</p>
      <p>{{ flight.date }}</p>
      <p>{{ flight.price }}</p>
      <p>{{flight.depLoc_name}}</p>
    </div>

  </div>

</template>

<style scoped>
  .container {
    display: flex;
  }

  .flightBody {
    background-color: #D7CDCC;
    height: 6vh;
    border-radius: 7px;
    margin: 5px;
    display: flex;
    width: 80vw;
  }

</style>