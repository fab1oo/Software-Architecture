package case1;

import org.camunda.bpm.client.ExternalTaskClient;

public class OrderWorker {

    /* Field declarations */
    final static String ENGINE_URL = "192.168.111.3:8080/engine-rest";
    final static String USERNAME = "group8";
    final static String PASSWORD = "w3poi3q44qqw4vt";
    final static String TOPIC = "group8_contactCarrier";

    /* Driver */
    public static void main(String[] args) {

        // Create connection to workflow engine
        ExternalTaskClient processClient = ExternalTaskClient.create()
                .baseUrl("http://" + USERNAME + ":" + PASSWORD + "@" + ENGINE_URL)
                .asyncResponseTimeout(1000)
                .build();

        // Register for the topic "group8_contactCarrier" and execute the following statements
        processClient.subscribe(TOPIC).lockDuration(1000).handler((externalTask, externalTaskService) -> {
            // Get variables from process instance
            String destination = (String) externalTask.getVariable("destination");
            String customerReference = (String) externalTask.getVariable("customerReference");
            String recipientPhone = (String) externalTask.getVariable("recipientPhone");
            Integer weight = (Integer) externalTask.getVariable("weight");

            // TODO: What to do here?

        }).open();
    }


}
