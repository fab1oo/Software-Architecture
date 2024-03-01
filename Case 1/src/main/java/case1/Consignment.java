package case1;

public class Consignment {

    /* Field declarations */
    private String orderId;
    private Integer weight;
    private String pickupdate;
    private String deliverydate;
    private String customerReference;
    private String recipientPhone;
    private String destination;

    /* Constructors */
    public Consignment() {
    }

    public Consignment(String orderId, Integer weight, String pickupdate, String deliverydate,
                       String customerReference, String recipientPhone, String destination) {
        this.orderId = orderId;
        this.weight = weight;
        this.pickupdate = pickupdate;
        this.deliverydate = deliverydate;
        this.customerReference = customerReference;
        this.recipientPhone = recipientPhone;
        this.destination = destination;
    }

    /* Getters and setters */
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPickupdate() {
        return pickupdate;
    }

    public void setPickupdate(String pickupdate) {
        this.pickupdate = pickupdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
