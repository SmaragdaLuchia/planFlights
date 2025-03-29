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
    <div class="flightBody">
      <h3>{{flight.depLoc_name}} -> {{flight.destination_name}}</h3>
      <p>{{ flight.date }}, {{flight.depTime}}</p>
      <p>airline: {{ props.flight.airline}}</p>
      <p>{{ flight.price }}€ per person</p>

    </div>



</template>

<style scoped>

  .flightBody {
    background-color: #D7CDCC;
    display: flex;
    border-radius: 7px;
    margin: 5px;
    width: 80vw;

    display: flex;
    flex-direction: column;
    align-items: flex-start;

  }

  h3 {
    margin-top: 20px;
    margin-left: 20px;
  }

  p {
    margin-left: 20px;
  }

</style>