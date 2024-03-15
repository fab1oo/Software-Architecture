public class NewConsignment {

    /* Field declarations */
    private String destination;
    private String customerReference;
    private String recepientPhone;
    private Integer weight;

    /* Constructors */
    public NewConsignment() {
    }

    public NewConsignment(String destination, String customerReference, String recepientPhone, Integer weight) {
        this.destination = destination;
        this.customerReference = customerReference;
        this.recepientPhone = recepientPhone;
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

    public String getRecepientPhone() {
        return recepientPhone;
    }

    public void setRecepientPhone(String recepientPhone) {
        this.recepientPhone = recepientPhone;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
