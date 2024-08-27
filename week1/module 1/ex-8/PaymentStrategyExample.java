public class PaymentStrategyExample {

    // Strategy Interface
    public interface PaymentMethod {
        void processPayment(String amount);
    }

    // Concrete Strategy - CreditCardMethod
    public static class CreditCardMethod implements PaymentMethod {
        @Override
        public void processPayment(String amount) {
            System.out.println("Processing " + amount + " via Credit Card.");
        }
    }

    // Concrete Strategy - PayPalMethod
    public static class PayPalMethod implements PaymentMethod {
        @Override
        public void processPayment(String amount) {
            System.out.println("Processing " + amount + " via PayPal.");
        }
    }

    // Context Class
    public static class PaymentService {
        private PaymentMethod paymentMethod;

        public void selectPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public void makePayment(String amount) {
            paymentMethod.processPayment(amount);
        }
    }

    // Test the Strategy Implementation
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.selectPaymentMethod(new CreditCardMethod());
        paymentService.makePayment("100 USD");

        paymentService.selectPaymentMethod(new PayPalMethod());
        paymentService.makePayment("200 USD");
    }
}
