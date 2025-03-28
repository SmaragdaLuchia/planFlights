<template>
  <div class="flightList">
    <flightCompo v-for="flight in flights" :key="flight.id" :flight="flight" />
  </div>
</template>

<script>
import axios from 'axios'
import FlightCompo from "@/components/flightCompo.vue";



export default {
  name: 'App',
  components: {FlightCompo},

  data() {
    return {
      message: 'Hello Vue!',
      flights: []
    }
  },
  mounted() {
    axios.get('http://localhost:8080/flights/')
      .then(response => {
        console.log("Fetching flight data")
        console.log(response.data)
        this.flights = response.data
      })
      .catch(error => {
        console.log(error)
      })
  }
}
</script>

<style>

.flightList {
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>
