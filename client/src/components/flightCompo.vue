<script setup>
import { defineProps } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const props = defineProps({
  flight: {
    type: Object,
    required: true
  }

});

const goBookFlight = () => {
  console.log("Vajutasid!")
  router.push({path: '/bookFlight', query: { flightId: props.flight.id}});
}





</script>

<template>
    <div class="flightBody" @click="goBookFlight" >
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

    flex-direction: column;
    align-items: flex-start;

    cursor: pointer;

  }

  .flightBody:hover {
    background-color: #AD9D9DFF;
    transform: scale(1.02);
  }


  h3 {
    margin-top: 20px;
    margin-left: 20px;
  }

  p {
    margin-left: 20px;
  }

</style>