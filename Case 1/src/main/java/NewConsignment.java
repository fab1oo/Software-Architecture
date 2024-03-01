public class NewConsignment {

    /* Field declarations */
    private String destination;
    private String customerReference;
    private String recipientPhone;
    private Integer weight;

    /* Constructors */
    public NewConsignment() {
    }

    public NewConsignment(String destination, String customerReference, String recipientPhone, Integer weight) {
        this.destination = destination;
        this.customerReference = customerReference;
        this.recipientPhone = recipientPhone;
        this.weight = weight;
    }

    /* Getters and setters */
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
