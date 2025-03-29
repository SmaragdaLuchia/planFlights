<template>
  <div class="container">
    <flight-filter-compo @update-flights="updateFilteredFlights"></flight-filter-compo>
  </div>
  <div class="flightList">
    <flightCompo v-for="flight in flights" :key="flight.id" :flight="flight" />
  </div>
</template>


<script>
import axios from 'axios'
import FlightCompo from "@/components/flightCompo.vue";
import FlightFilterCompo from "@/components/flightFilterCompo.vue";

export default {
  name: 'chooseFlightView',
  components: {FlightCompo, FlightFilterCompo},

  data() {
    return {
      flights: [],
    }
  },
  methods: {
    updateFilteredFlights(flights) {
      this.flights = flights;
    }
  },
  mounted() {
    console.log('Mounted!');
    axios.get('http://localhost:8080/flights/')
        .then(response => {
          console.log("Fetching flight data");
          console.log("Received data:", response.data);
          this.flights = response.data;
        })
        .catch(error => {
          console.log(error);
        });
  },
}
</script>

<style>

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.flightList {
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>

