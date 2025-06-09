package Receiving;

import java.time.LocalDate;

public class Receiving {
    protected String receivingId;
    protected LocalDate date;
    protected String supplierName;

    public Receiving(String receivingId, LocalDate date, String supplierName) {
        this.receivingId = receivingId;
        this.date = date;
        this.supplierName = supplierName;
    }

    public void recordReceiving() {
        System.out.println("Receiving recorded: " + receivingId);
    }

    public boolean validateReceiving() {
        return receivingId != null && !receivingId.isEmpty();
    }

    public void printReceivingDetails() {
        System.out.println("Receiving ID: " + receivingId + ", Date: " + date + ", Supplier: " + supplierName);
    }
}