import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import FlightClient from "../api/flightClient";

/**
 * Logic needed for the view playlist page of the website.
 */
class FlightPage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onGetFlight', 'onCreateFlight', 'renderFlight'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the concert list.
     */
    async mount() {
       document.getElementById('search-form').addEventListener('submit', this.onGet);
       document.getElementById('create-flight-form').addEventListener('submit', this.onCreate);
       this.client = new FlightClient();

       this.dataStore.addChangeListener(this.renderFlight);
       this.onGetFlight();
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderFlight() {
        let resultArea = document.getElementById("result-info");

        const flights = this.dataStore.get("flightInfo");

        let myNewHTML = "";
        myNewHTML += "<ul>";

        // for(let flight of flights) {
        //    myNewHTML += `<li><h3>Flight Id: ${flight.id}</h3></li>`;
        //    myNewHTML += `<h4>Booked By: ${flight.name}</h4>`;
        // }
        // if(flights){
        //    resultArea.innerHTML = myNewHTML;
        // }else{
        //    resultArea.innerHTML = "No comments";
        // }

        if (flights) {
            resultArea.innerHTML = `
                <div>FlightId: ${flightInfo.value}</div>
                <div>NAME: ${flightInfo.name}</div>
            `
        } else {
            resultArea.innerHTML = "No Item";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onGetFlight(event) {
        // Prevent the page from refreshing on form submit
        // event.preventDefault();
        // let flightId = document.getElementById("flight-id-entry").value;
        // const flights = this.dataStore.get("flightInfo");
        // let result = await this.client.getFlight();
        // this.dataStore.set("flightInfo", result);

        let flightId = document.getElementById("id-field").value;
        this.dataStore.set("flightInfo", null);
        //
        let result = await this.client.getFlight(flightId, this.errorHandler);
        this.dataStore.set("flightInfo", result);
        if (result) {
            this.showMessage(`Got ${result.name}!`)
        } else {
            this.errorHandler("Error doing GET!  Try again...");
        }
        // event.preventDefault();
        // this.dataStore.set("flightInfo", null);

    }

    async onCreateFlight(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();
        // this.dataStore.set("flightInfo", null);

        let name = document.getElementById("create-flight-name").value;
        let email = document.getElementById("create-flight-email").value;
        let originZipcode = document.getElementById("create-flight-from").value;
        let destinationZipcode = document.getElementById("create-flight-goingTo").value;
        let numOfPassengers = document.getElementById("create-flight-passenger").value;
        let paymentMethod = document.getElementById("create-flight-pay").value;

        const createdFlight = await this.client.createFlight(name, email, originZipcode, destinationZipcode, numOfPassengers, paymentMethod, this.errorHandler);
        // this.dataStore.set("flightInfo", createdFlight);

        if (createdFlight) {
            this.showMessage("Created flight")
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
        await this.onGetFlight();
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