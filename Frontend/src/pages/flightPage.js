import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import FlightClient from "../api/flightClient";

/**
 * Logic needed for the view playlist page of the website.
 */
class FlightPage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onGetFlight', 'onCreateFlight', 'onGetAllFlights', 'onDeleteFlight', 'renderFlight', 'renderFlightSearched', 'renderAllFlights'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the concert list.
     */
    async mount() {
       document.getElementById('search-flight-form').addEventListener('submit', this.onGetFlight);
       document.getElementById('create-flight-form').addEventListener('submit', this.onCreateFlight);
//       document.getElementById('flight-list-form').addEventListener('submit', this.onGetAllFlights);
       this.client = new FlightClient();

       this.dataStore.addChangeListener(this.renderFlight);
       this.dataStore.addChangeListener(this.renderFlightSearched);
       this.dataStore.addChangeListener(this.renderAllFlights);
       this.onGetAllFlights();
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderFlight() {
        let creatingFlight = document.getElementById("result-info");

        const flights = this.dataStore.get("flightInformation");

        if (flights) {
            creatingFlight.innerHTML = `
                <div>FlightId: ${flights.flightId}</div>
                <div>Name: ${flights.name}</div>
                <div>Email: ${flights.email}</div>
                <div>Origin ZipCode: ${flights.originZipcode}</div>
                <div>Destination ZipCode: ${flights.destinationZipcode}</div>
                <div>Number of Passengers: ${flights.numOfPassengers}</div>
                <div>Payment Method: ${flights.paymentMethod}</div>
            `
        }
//        else {
//            creatingFlight.innerHTML = "Flight doesn't exist in database!!!";
//        }
    }

    async renderFlightSearched() {
        let searchingFlight = document.getElementById("result-info");

        const flights = this.dataStore.get("flightInformation");

        if(flights) {
            searchingFlight.innerHTML =`
                <div>FlightId: ${flights.flightId}</div>
                <div>Name: ${flights.name}</div>
                <div>Email: ${flights.email}</div>
                <div>Origin ZipCode: ${flights.originZipcode}</div>
                <div>Destination ZipCode: ${flights.destinationZipcode}</div>
                <div>Number of Passengers: ${flights.numOfPassengers}</div>
                <div>Payment Method: ${flights.paymentMethod}</div>
            `
        }
        else {
            searchingFlight.innerHTML = "Flight doesn't exist in database!!!!!!!!!!!"
        }
    }

    async renderAllFlights(){
        let allFlights = document.getElementById("results-info");

        const flights = this.dataStore.get("flights");

        let result = "";
        result += "<ul>"

        for(let flight of flights) {
            result += `<li><div>FlightId: ${flight.flightId}</div></li>
               <div>Name: ${flight.name}</div>
               <div>Email: ${flight.email}</div>
               <div>Origin ZipCode: ${flight.originZipcode}</div>
               <div>Destination ZipCode: ${flight.destinationZipcode}</div>
               <div>Number of Passengers: ${flight.numOfPassengers}</div>
               <div>Payment Method: ${flight.paymentMethod}</div>`;
        }

        if(result){
            allFlights.innerHTML = result;
        } else{
            allFlights.innerHTML = "No current flights";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onGetFlight(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();

        let flightId = document.getElementById("search-flight-field").value;
        this.dataStore.set("flightInformation", null);

        let searchedFlight = await this.client.getFlight(flightId, this.errorHandler);
        this.dataStore.set("flightInformation", searchedFlight);

        if (searchedFlight) {
            this.showMessage(`Got ${searchedFlight.name}!`)
        } else {
            this.errorHandler("Error finding flight, please enter a valid flight ID!");
        }

    }

    async onGetAllFlights() {
        let result = await this.client.getAllFlights(this.errorHandler);
        this.dataStore.set("flights", result);
    }

    async onCreateFlight(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();
        this.dataStore.set("flightInformation", null);

        let name = document.getElementById("create-flight-name").value;
        let email = document.getElementById("create-flight-email").value;
        let originZipcode = document.getElementById("create-flight-from").value;
        let destinationZipcode = document.getElementById("create-flight-goingTo").value;
        let numOfPassengers = document.getElementById("create-flight-passenger").value;
        let paymentMethod = document.getElementById("create-flight-pay").value;

        const createdFlight = await this.client.createFlight(name, email, originZipcode, destinationZipcode, numOfPassengers, paymentMethod, this.errorHandler);
        this.dataStore.set("flightInformation", createdFlight);

        if (createdFlight) {
            this.showMessage(`Sky travel initiated successfully by ${createdFlight.name}!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
    }

    async onDeleteFlight(){
        let flightId = document.getElementById("delete-flight-id").value;
        this.dataStore.set("flightInformation", flightId);

        let deletedFlight = await this.client.deleteFlight(flightId, this.errorHandler);
        this.dataStore.set("flightInformation", null);

        if (deletedFlight) {
           this.showMessage(`Cancelled ${deletedFlight.name}!`)
        } else {
           this.errorHandler("Error finding flight, please enter a valid flight ID!");
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const flightPage = new FlightPage();
    flightPage.mount();
};

window.addEventListener('DOMContentLoaded', main);