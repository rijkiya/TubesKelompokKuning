package Payment;

public class COD extends Payment {
    private String deliveryPerson;
    private boolean isPaid;

    public COD() {
        super();
        this.deliveryPerson = "Kurir A";
        this.isPaid = false;
    }

    public void markAsPaid() {
        isPaid = true;
    }

    public String getDeliveryDetails() {
        return "COD oleh " + deliveryPerson + ", Status: " + (isPaid ? "Lunas" : "Belum Dibayar");
    }
}