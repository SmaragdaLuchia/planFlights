<script setup>
import {useRoute} from "vue-router";
import axios from "axios";
import {onMounted, ref} from "vue";
import router from "@/router";

const route = useRoute();
const flightId = route.query.flightId

const seats = ref([])
const flight = ref(null);
const pickedSeat = ref(null);

const requestByWindow = ref(false)
const requestMoreLegroom = ref(false)
const requestNearExit = ref(false)

const bookSeat = async (seatNr) => {
  try {
    console.log(`http://localhost:8080/bookFlight/${flightId}/occupySeat/${seatNr}`)
    const response = await axios.post(`http://localhost:8080/bookFlight/${flightId}/occupySeat/${seatNr}`);
    console.log("Seat booked successfully:", response.data);
    await router.push({path: '/'});
  } catch (error) {
    console.error("Error booking seat:", error);
  }
}

const isSuggested = (byWindow, moreLegroom, nearExit) => {
  if (requestByWindow.value) {
    if (!byWindow) {
      return false
    }
  }
  if (requestMoreLegroom.value) {
    if (!moreLegroom) {
      return false
    }
  }
  if (requestNearExit.value) {
    if (!nearExit) {
      return false
    }
  }

  return (requestByWindow.value || requestMoreLegroom.value || requestNearExit.value);

}

const cancelBook = () => {
  router.push({path: '/'});
}

const setSeat = (seatToBePicked) => {
  if (!seatToBePicked.occupied) {
    pickedSeat.value = seatToBePicked.seatNr
  }
  console.log(pickedSeat.value)
}

const initialSeat = () => {
  for (const seat of seats.value) {
    if (!seat.occupied) {
      pickedSeat.value = seat.seatNr
      break
    }
  }
}

const fetchData = () => {
  axios.get(`http://localhost:8080/bookFlight/${flightId}/seats`)
      .then(response => {
        console.log("Fetching seats data");
        console.log("Received data:", response.data);
        seats.value = response.data;
        initialSeat()
      })
      .catch(error => {
        console.log(error);
      });

  axios.get(`http://localhost:8080/flights/getFlight/${flightId}`)
      .then((response) => {
        console.log("Fetching flight data");
        console.log("Received data:", response.data);
        flight.value = response.data; // Set flight data
      })
      .catch((error) => {
        console.log(error);
      });

}

onMounted(fetchData)


</script>

<template>
  <div class="container">
    <div class="seatPlanContainer">
      <div class="seatPlan">
        <div v-for="seat in seats"
             :key="seat.id"
             :occupied="seat.occupied"
             :seatNr="seat.seatNr"
             :byWindow="seat.byWindow"
             :nearExit="seat.nearExit"
             :moreLegRoom="seat.moreLegRoom"
             :class="['seat', {'occupied' : seat.occupied, 'picked' : seat.seatNr === pickedSeat, 'suggested' : !seat.occupied && isSuggested(seat.byWindow, seat.moreLegRoom, seat.nearExit)}]"
             @click="setSeat(seat)"
             >
          {{seat.seatNr}}
        </div>

      </div>
    </div>
    <div class="suggestionContainer">
      <div class="flightInfoContainer">
        <h1 v-if="flight">{{ flight.departureLocation }} -> {{ flight.destination.name }}</h1>
        <h1 v-else>Loading flight data...</h1>

        <p v-if="flight" class="text">{{ flight.date }}, {{ flight.depTime }}</p>
      </div>
      <div class="seatInfo">
        <div class="seat occupied infoSeat"/>
        <p class="text">OCCUPIED</p>
        <div class="seat picked infoSeat"/>
        <p class="text">YOUR PICK</p>
        <div class="seat suggested infoSeat"/>
        <p class="text infoSuggestionText">SUGGESTED</p>
      </div>

      <div class="suggestion">
        <p class="text preferencesText">Pick your preferences</p>
        <label class="text">
         <input type="checkbox" v-model="requestByWindow" class="checkBox">
          Seat by window
        </label>
        <label class="text">
          <input type="checkbox" v-model="requestMoreLegroom" class="checkBox">
          Premium legroom
        </label>
        <label class="text">
          <input type="checkbox" v-model="requestNearExit" class="checkBox">
          Seat near exit
        </label>
      </div>
      <div class="buttonContainer">
        <button @click="cancelBook">CANCEL</button>
        <button class="bookButton" @click="bookSeat(pickedSeat)">BOOK</button>
      </div>
    </div>
  </div>


</template>

<style scoped>

.container {
  display: flex;
  flex-direction: row;
}

.seatPlanContainer {
  width: 40vw;
  display: flex;
  justify-content: center;
}


.suggestionContainer {
  justify-self: flex-start;
  align-self: flex-start;

  display: flex;
  width: 60vw;
  flex-direction: column;
  margin-left: 2vw;
  justify-content: flex-start;
  align-items: flex-start;

  gap: 21px;
}

.buttonContainer {
  display: flex;
  justify-content: space-between;
  width: 50vw;
}

.flightInfoContainer {
  display: flex;
  flex-direction: column;
  width: 100%;
  align-items: flex-start;
}

h1 {
  font-family: 'Rubik', sans-serif;
  font-weight: 300;
  font-size: 65px;

  margin-top: 10px;
  margin-bottom: 10px;
}

.seatPlan {
  display: grid;
  grid-template-columns: 2fr 1fr 1fr;
  grid-template-rows: repeat(7, 1fr);
  gap: 10px 10px;

  width: 29vw;
  min-width: 400px;
  max-width: 800px;
  aspect-ratio: 10/17;

  border-radius: 15px;
  background: #D7CDCC;
}

.seat {
  min-width:75px;
  min-height: 75px;

  width: 5vw;
  height: 5vw;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  margin: 10px;
  cursor: pointer;

  font-family: 'Rubik', sans-serif;
  font-weight: 300;
  font-size: 25px;

  background-color: #F3EBEA;
  align-self: center;
}

.occupied {
  background-color: #B53424;
  cursor: default;
}

.suggested {
  background-color: #87B56A;
}

.picked {
  background-color: #877876;
}


.seatInfo {
  min-width: 600px;
  width: 50vw;
  aspect-ratio: 17/3;
  background: #D7CDCC;
  border-radius: 15px;

  display: flex;
  justify-content: space-between;
  align-items: center;

}

.infoSeat {
  min-width: 35px;
  min-height: 35px;

  width: 2vw;
  height: 2vw;

  margin: 1vw;

  cursor: default;
}

.suggestion {
  border-radius: 15px;
  background: #D7CDCC;

  min-width: 600px;
  width: 50vw;
  aspect-ratio: 17/7;

  display: flex;
  flex-direction: column;
  align-items: flex-start;
}



.text {
  font-family: 'Rubik', sans-serif;
  font-weight: 300;
  font-size: 30px;

  margin-top: 10px;
  margin-bottom: 10px;

}

.infoSuggestionText {
  margin-right: 2vw;
}

.preferencesText {
  margin: 20px;
  font-size: 35px;
}


button {
  min-width: 345px;
  width: 24.2vw;
  aspect-ratio: 16/3;

  border: 1px solid #ccc;
  border-radius: 15px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  cursor: pointer;

  font-family: 'Rubik', sans-serif;
  font-weight: 300;
  font-size: 25px;

  background-color: #D7CDCC;
}

.bookButton {
  background-color: #877876;
  color: white;
}

input[type="checkbox"] {

}

.checkBox {
  width: 20px;
  height: 20px;

  margin: 10px 10px 10px 20px;
}

</style>