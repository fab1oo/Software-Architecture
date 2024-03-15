import org.camunda.bpm.client.ExternalTaskClient;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

public class ContactCarrierWorker {

    /* Field declarations */
    final static String SERVICE_URL = "http://192.168.111.5:8080/v1";
    final static String POST_PATH = "/consignment/request";
    final static String ENGINE_URL = "192.168.111.3:8080/engine-rest";
    final static String USERNAME = "group8";
    final static String PASSWORD = "w3poi3q44qqw4vt";
    final static String TOPIC = "group8_meinExternerTask";

    /* Driver */
    public static void main(String[] args) {
        // Create connection to workflow engine
        ExternalTaskClient processClient = ExternalTaskClient.create()
                .baseUrl("http://" + USERNAME + ":" + PASSWORD + "@" + ENGINE_URL)
                .asyncResponseTimeout(1000)
                .build();

        // Register for the topic "group8_meinExternerTask" and execute the following statements
        processClient.subscribe(TOPIC).lockDuration(1000).handler((externalTask, externalTaskService) -> {
            // Get variables from process instance
            String destination = (String) externalTask.getVariable("destination");
            String customerReference = (String) externalTask.getVariable("customerReference");
            String recepientPhone = (String) externalTask.getVariable("recepientPhone");
            Long weightLong = externalTask.getVariable("weight");
            Integer weight = weightLong.intValue();

            // Create REST client and target for requests
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(SERVICE_URL + POST_PATH);
            // Create message for request
            NewConsignment newConsignment = new NewConsignment();
            newConsignment.setDestination(destination);
            newConsignment.setCustomerReference(customerReference);
            newConsignment.setRecepientPhone(recepientPhone);
            newConsignment.setWeight(weight);

            // Send POST request with newConsignment as request body
            try {
                Consignment response = target.request(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(newConsignment, MediaType.APPLICATION_JSON), Consignment.class);
                // Generate result map
                Map<String, Object> results = new HashMap<String, Object>();
                results.put("statusCode", 200);
                results.put("orderId", response.getOrderId());
                results.put("weight", response.getWeight());
                results.put("pickupdate", response.getPickupdate());
                results.put("deliverydate", response.getDeliverydate());
                results.put("customerReference", response.getCustomerRefernce());
                results.put("recepientPhone", response.getRecepientPhone());
                results.put("destination", response.getDestination());
                System.out.println("Response carrier: " + results);
                externalTaskService.complete(externalTask, results);
            } catch (WebApplicationException e) {
                // If HTTP status code of request is not 200
                if (e.getResponse().getStatus() != 200) {
                    System.out.println("Service request failed!");
                    Map<String, Object> results = new HashMap<String, Object>();
                    results.put("statusCode", e.getResponse().getStatus());
                    externalTaskService.complete(externalTask, results);
                }
            }
            client.close();
        }).open();
    }

}
