import java.util.ArrayList;
import java.util.List;

public class MarketObserverDemo {

    // Interface for the subject
    public interface PriceNotifier {
        void addObserver(Subscriber subscriber);
        void removeObserver(Subscriber subscriber);
        void notifySubscribers();
    }

    // Concrete subject class
    public static class StockPriceTracker implements PriceNotifier {
        private List<Subscriber> subscribers = new ArrayList<>();
        private double price;

        public void updatePrice(double price) {
            this.price = price;
            notifySubscribers();
        }

        @Override
        public void addObserver(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void removeObserver(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        @Override
        public void notifySubscribers() {
            for (Subscriber subscriber : subscribers) {
                subscriber.alert(price);
            }
        }
    }

    // Interface for the observer
    public interface Subscriber {
        void alert(double price);
    }

    // Concrete observer class for mobile notifications
    public static class MobileNotifier implements Subscriber {
        @Override
        public void alert(double price) {
            System.out.println("Mobile Notifier: Stock price is now " + price);
        }
    }

    // Concrete observer class for web notifications
    public static class WebNotifier implements Subscriber {
        @Override
        public void alert(double price) {
            System.out.println("Web Notifier: Stock price is now " + price);
        }
    }

    // Test the simplified Observer pattern implementation
    public static void main(String[] args) {
        StockPriceTracker tracker = new StockPriceTracker();
        Subscriber mobileNotifier = new MobileNotifier();
        Subscriber webNotifier = new WebNotifier();

        tracker.addObserver(mobileNotifier);
        tracker.addObserver(webNotifier);

        tracker.updatePrice(100.50);
        tracker.updatePrice(102.75);
    }
}
