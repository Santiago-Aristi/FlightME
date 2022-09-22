import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import ExampleClient from "../api/exampleClient";

/**
 * Logic needed for the view playlist page of the website.
 */
class ExamplePage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onCreate', 'renderExample'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the concert list.
     */
    async mount() {
        document.getElementById('create-cargo-flight').addEventListener('submit', this.onCreate);
        this.client = new CargoClient();

        this.dataStore.addChangeListener(this.renderFlight)
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderFlight() {
        let resultArea = document.getElementById("result-info");

        const flight = this.dataStore.get("flight");

        if (flight) {
            resultArea.innerHTML = `
                <div>ID: ${flight.id}</div>
                <div>Name: ${flight.name}</div>
            `
        } else {
            resultArea.innerHTML = "No Item";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onCreate(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();
        this.dataStore.set("flight", null);

        let name = document.getElementById("create-flight-name").value;

        const createdFlight = await this.client.createExample(name, this.errorHandler);
        this.dataStore.set("flight", createdFlight);

        if (createdFlight) {
            this.showMessage(`Created flight for ${createdFlight.name}!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
    }

    async createFlight(name, errorCallback){
        try{
           const response = await this.client.post(`/cargo`, {
            "name" : name;
           });
           return response.data;
        }catch(error){
            this.handleError("createFlight", error, errorCallback);
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const cargoPage = new CargoPage();
    cargoPage.mount();
};

window.addEventListener('DOMContentLoaded', main);