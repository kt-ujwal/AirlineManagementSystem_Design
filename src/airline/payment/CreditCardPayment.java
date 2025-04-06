package airline.payment;

public class CreditCardPayment implements PaymentStrategy {
    public void processPayment(Payment payment) {
        payment.setStatus(PaymentStatus.COMPLETED);
    }
    public CreditCardPayment(){}
}
