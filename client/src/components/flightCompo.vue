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
      <div class="container1">
        <h3 class="text locText">{{flight.depLoc_name}} -> {{flight.destination_name}}</h3>
        <p class="text">{{ flight.date }}, {{flight.depTime}}</p>
        <p class="text">airline: {{ props.flight.airline}}</p>
      </div>
      <div class="container2">
        <p class="text price">{{ flight.price }}€</p>
      </div>
    </div>
</template>

<style scoped>

  .flightBody {
    background-color: #D7CDCC;
    display: flex;
    border-radius: 7px;
    margin: 5px;
    width: 80vw;

    flex-direction: row;
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

  .text {
    font-family: 'Rubik', sans-serif;
    font-weight: 300;
    font-size: 20px;

    margin-top: 10px;
    margin-bottom: 10px;

  }

  .locText {
    margin: 20px 20px 10px 20px;
    font-weight: 300;
    font-size: 30px;
  }
  .price {
    align-self: flex-end;
    font-size: 40px;
    margin-top: 7vh;
  }

  .container1 {
    display: flex;
    align-items: flex-start;
    flex-direction: column;
  }
  .container2 {
    display: flex;
    width: 60%;
    flex-direction: row;
    justify-content: flex-end;
  }

</style>