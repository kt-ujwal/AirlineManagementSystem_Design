package airline.payment;

public class Payment {
    private final String paymentId;
    private final double amount;
    private final String paymentMethod;
    private PaymentStatus status;

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        status = PaymentStatus.COMPLETED;
    }
}
