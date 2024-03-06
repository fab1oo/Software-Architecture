public class Consignment {

    /* Field declarations */
    private String orderId;
    private Integer weight;
    private String pickupdate;
    private String deliverydate;
    private String customerRefernce;
    private String recepientPhone;
    private String destination;

    /* Constructors */
    public Consignment() {
    }

    public Consignment(String orderId, Integer weight, String pickupdate, String deliverydate,
                       String customerRefernce, String recepientPhone, String destination) {
        this.orderId = orderId;
        this.weight = weight;
        this.pickupdate = pickupdate;
        this.deliverydate = deliverydate;
        this.customerRefernce = customerRefernce;
        this.recepientPhone = recepientPhone;
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

    public String getCustomerRefernce() {
        return customerRefernce;
    }

    public void setCustomerRefernce(String customerReference) {
        this.customerRefernce = customerReference;
    }

    public String getRecepientPhone() {
        return recepientPhone;
    }

    public void setRecepientPhone(String recipientPhone) {
        this.recepientPhone = recipientPhone;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
