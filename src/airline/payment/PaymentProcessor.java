package airline.payment;

public class PaymentProcessor {
    private final PaymentStrategy strategy;
    private static PaymentProcessor instance;
    public static PaymentProcessor getInstance(PaymentStrategy paymentStrategy) {
        if (instance == null) {
            synchronized (PaymentProcessor.class) {
                if (instance == null) {
                    instance = new PaymentProcessor(paymentStrategy);
                }
            }
        }
        return instance;
    }

    private PaymentProcessor(PaymentStrategy strategy)
    { this.strategy = strategy;
    }

    public void processPayment(Payment payment) {
        strategy.processPayment(payment);
    }
}
