import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import ExampleClient from "../api/flightClient";

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

        this.dataStore.addChangeListener(this.renderFlight)
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderFlight() {
        let resultArea = document.getElementById("result-info-create");

        const flight = this.dataStore.get("flights");

        let result = "";
        result+="<ul>"

        for(let flight of flights){
            result+=`<h3>flight.name</h3>`;
        }

        result+="</ul>"

        if (result) {
            resultArea.innerHTML = result;
        } else {
            resultArea.innerHTML = "No Item";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onGet(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();

        let id = document.getElementById("search").value;
        this.dataStore.set("flight", null);

        let result = await this.client.getFlight(id, this.errorHandler);
        this.dataStore.set("flight", result);
        if (result) {
            this.showMessage(`Got ${result.name}!`)
        } else {
            this.errorHandler("Error doing GET!  Try again...");
        }
    }

    async onCreate(flight) {
        // Prevent the page from refreshing on form submit
        flight.preventDefault();
        this.dataStore.set("flight", null);

        let name = document.getElementById("create-flight-name").value;
        let email = document.getElementById("create-flight-email").value;
        let originZipcode = document.getElementById("create-flight-from").value;
        let destinationZipcode = document.getElementById("create-flight-goingTo").value;
        let payment = document.getElementById("create-flight-pay").value;

        const createdFlight = await this.client.createFlight(name, this.errorHandler);
        this.dataStore.set("example", createdExample);

        if (createdFlight) {
            this.showMessage(`Created ${createdFlight.name}!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
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