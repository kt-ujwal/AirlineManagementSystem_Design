package airline.payment;

public class PaymentProcessor {
    private static PaymentProcessor instance;
    public static PaymentProcessor getInstance() {
        if (instance == null) {
            synchronized (PaymentProcessor.class) {
                if (instance == null) {
                    instance = new PaymentProcessor();
                }
            }
        }
        return instance;
    }

    private PaymentProcessor() {}

    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}
