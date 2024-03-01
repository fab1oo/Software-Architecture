import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ContactCarrierWorker {

    /* Field declarations */
    final static String SERVICE_URL = "http://192.168.111.5:8080/v1";
    final static String POST_PATH = "/consignment/request";
    final static String ENGINE_URL = "192.168.111.3:8080/engine-rest";
    final static String USERNAME = "group8";
    final static String PASSWORD = "w3poi3q44qqw4vt";
    final static String TOPIC = "group8_contactCarrier";

    /* Driver */
    public static void main(String[] args) {

        // Create REST client and target for requests
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(SERVICE_URL + POST_PATH);

        // Create message for request
        NewConsignment newConsignment = new NewConsignment();
        newConsignment.setDestination("Baden, Rütistrasse 1"); // destination
        newConsignment.setCustomerReference("xyz"); // purchaseId?
        newConsignment.setRecipientPhone("+41 76 393 25 49"); // recipientPhone
        newConsignment.setWeight(125); // weight

        // Send POST request with newConsignment as request body
        try {
            Consignment response = target.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(newConsignment, MediaType.APPLICATION_JSON), Consignment.class);

            // print some results received from the service
            System.out.println("Shipping Order ID: " + response.getOrderId());
            System.out.println("Pickup Date      : " + response.getPickupdate());
            System.out.println("Delivery Date    : " + response.getDeliverydate());

            // TODO: What to do here?

        } catch (WebApplicationException e) {
            // If HTTP status code of request is not 200
            if (e.getResponse().getStatus() != 200) {
                // TODO: What to do here?
            } else {

            }
        }

        client.close();

    }

}
