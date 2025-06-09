package Payment;

import java.time.LocalDate;

public class Payment {
    protected String paymentId;
    protected double amount;
    protected LocalDate paymentDate;

    public Payment() {
        this.paymentId = "PMT001";
        this.amount = 100.0;
        this.paymentDate = LocalDate.now();
    }

    public boolean processPayment() {
        return true;
    }

    public String getPaymentStatus() {
        return "Pembayaran " + paymentId + " sebesar " + amount + " telah diproses pada " + paymentDate;
    }
}