public class MessageDecoratorDemo {

    // Base Interface for messaging
    public interface Messenger {
        void notify(String message);
    }

    // Basic messaging class
    public static class BasicEmailMessenger implements Messenger {
        @Override
        public void notify(String message) {
            System.out.println("Email sent: " + message);
        }
    }

    // Abstract Decorator class
    public static abstract class MessengerDecorator implements Messenger {
        protected Messenger messenger;

        public MessengerDecorator(Messenger messenger) {
            this.messenger = messenger;
        }

        @Override
        public void notify(String message) {
            messenger.notify(message);
        }
    }

    // SMS messaging decorator
    public static class SMSMessengerDecorator extends MessengerDecorator {
        public SMSMessengerDecorator(Messenger messenger) {
            super(messenger);
        }

        @Override
        public void notify(String message) {
            super.notify(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("SMS sent: " + message);
        }
    }

    // Slack messaging decorator
    public static class SlackMessengerDecorator extends MessengerDecorator {
        public SlackMessengerDecorator(Messenger messenger) {
            super(messenger);
        }

        @Override
        public void notify(String message) {
            super.notify(message);
            sendSlack(message);
        }

        private void sendSlack(String message) {
            System.out.println("Slack message sent: " + message);
        }
    }

    // Test the simplified Decorator pattern
    public static void main(String[] args) {
        Messenger emailMessenger = new BasicEmailMessenger();
        Messenger smsMessenger = new SMSMessengerDecorator(emailMessenger);
        Messenger slackMessenger = new SlackMessengerDecorator(smsMessenger);

        slackMessenger.notify("Hello, World!");
    }
}
