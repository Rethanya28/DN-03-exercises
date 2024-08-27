public class PaymentAdapterPattern {

    // Interface for payment processing
    public interface PaymentHandler {
        void handlePayment(String amount);
    }

    // PayApp class
    public static class PayApp {
        public void pay(String amount) {
            System.out.println("Paid " + amount + " using PayApp.");
        }
    }

    // QuickPay class
    public static class QuickPay {
        public void transact(String amount) {
            System.out.println("Transacted " + amount + " using QuickPay.");
        }
    }

    // Adapter for PayApp
    public static class PayAppAdapter implements PaymentHandler {
        private PayApp payApp;

        public PayAppAdapter(PayApp payApp) {
            this.payApp = payApp;
        }

        @Override
        public void handlePayment(String amount) {
            payApp.pay(amount);
        }
    }

    // Adapter for QuickPay
    public static class QuickPayAdapter implements PaymentHandler {
        private QuickPay quickPay;

        public QuickPayAdapter(QuickPay quickPay) {
            this.quickPay = quickPay;
        }

        @Override
        public void handlePayment(String amount) {
            quickPay.transact(amount);
        }
    }

    // Test the simplified Adapter Pattern
    public static void main(String[] args) {
        PaymentHandler payAppHandler = new PayAppAdapter(new PayApp());
        payAppHandler.handlePayment("100 Dollars");

        PaymentHandler quickPayHandler = new QuickPayAdapter(new QuickPay());
        quickPayHandler.handlePayment("200 Dollars");
    }
}
