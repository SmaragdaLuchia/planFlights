<script>
import axios from 'axios'
import Datepicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'

export default {

  components: { Datepicker },
  data() {
    return {
      selectedDate: null,
      selectedDestination: null,
      selectedAirline: null,
      selectedMaxPrice: null,

      destinations: [],
      airlines: [],
      filteredFlights: [],

    };
  },
  methods: {
    filterFlights() {
      const url = `http://localhost:8080/flights/search?${this.getQueryParams()}`
      console.log("Query Parameters:", url);

      axios.get(url)
          .then(response => {
            console.log("Fetching filtered flights");
            console.log("Received data:", response.data);
            this.filteredFlights = response.data;
            this.$emit('update-flights', this.filteredFlights)
          })
          .catch(error => {
            console.log(error);
          });

    },
    priceIsFloat() {
      return this.isNumeric(this.selectedMaxPrice)
    },
    isNumeric(value) {
      return !isNaN(value) && !isNaN(parseFloat(value));
    },
    formatData() {
      if (this.selectedDate) {
        const date = new Date(this.selectedDate);
        const year = date.getFullYear();
        const month = (date.getMonth() + 1).toString().padStart(2, '0'); // Ensure two-digit month
        const day = date.getDate().toString().padStart(2, '0'); // Ensure two-digit day

        this.selectedDate = `${year}-${month}-${day}`;
      }

    },
    getQueryParams() {
      this.formatData()
        const filters = [
          {name: 'maxPrice', value: this.selectedMaxPrice, queryParam: 'price'},
          {name: 'airline', value: this.selectedAirline, queryParam: 'airline'},
          {name: 'date', value: this.selectedDate, queryParam: 'date'},
          {name: 'destination', value: this.selectedDestination, queryParam: 'destination'}
        ];
        return filters
            .filter(filter => filter.value !== null && filter.value !== '')
            .map(filter => `${filter.queryParam}=${encodeURIComponent(filter.value)}`)
            .join('&');
      }

  },
  mounted() {
    axios.get('http://localhost:8080/flights/destinations')
        .then(response => {
          console.log("Fetching destinations data");
          console.log("Received data:", response.data);
          this.destinations = response.data;
        })
        .catch(error => {
          console.log(error);
        });

    axios.get('http://localhost:8080/flights/airlines')
        .then(response => {
          console.log("Fetching airlines data");
          console.log("Received data:", response.data);
          this.airlines = response.data;
        })
        .catch(error => {
          console.log(error);
        });
  }
}


</script>

<template>
  <div class="filterBody">
    <div class="container">
      <label for="destinationChoice">Select destination</label>
      <select id="destinationChoice" v-model="selectedDestination">
        <option v-for="destination in destinations" :key="destination.id">
          {{ destination.name }}
        </option>
      </select>
      <label for="airlineChoice">Select airline</label>
      <select id="airlineChoice" v-model="selectedAirline">
        <option v-for="airline in airlines" :key="airline.id">
          {{ airline.name }}
        </option>
      </select>
    </div>
    <div class="container">
      <label>Select date:</label>
      <Datepicker v-model="selectedDate" :min-date="new Date()" :enable-time-picker="false" />
      <label for="maxPrice">Select maximum price:</label>
      <input
          class="priceInput"
          id="maxPrice"
          type="number"
          v-model.number="selectedMaxPrice"
          min="0"
      />
    </div>
    <div class="container">
      <button @click="filterFlights">Search</button>
    </div>
  </div>
</template>

<style scoped>



.container{
  width: 27vw;
  align-items: center;
  justify-content: center;

}

.filterBody{
  display: flex;
  flex-direction: row;
  background-color: #D7CDCC;
  height: 150px;
  border-radius: 7px;
  margin: 5px;
  width: 80vw;
}

input, select, button {
  padding: 8.5px;
  font-size: 16px;
  width: 320px;
  background-color: #ffffffff;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  cursor: pointer;
}


button {
  width: 320px;
  background-color: #c0c0c0;
  margin-top: 15px;
  margin-bottom: 4px;
}

.priceInput {
  width: 370px;
}

</style>