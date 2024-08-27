class Purchase {
    private int id;
    private String buyer;
    private double amount;

    public Purchase(int id, String buyer, double amount) {
        this.id = id;
        this.buyer = buyer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getBuyer() {
        return buyer;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Purchase[ID=" + id + ", Buyer=" + buyer + ", Amount=" + amount + "]";
    }
}

class Sorter {

    public static void bubbleSort(Purchase[] purchases) {
        int n = purchases.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (purchases[j].getAmount() > purchases[j + 1].getAmount()) {
                    Purchase temp = purchases[j];
                    purchases[j] = purchases[j + 1];
                    purchases[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Purchase[] purchases, int low, int high) {
        if (low < high) {
            int pi = partition(purchases, low, high);
            quickSort(purchases, low, pi - 1);
            quickSort(purchases, pi + 1, high);
        }
    }

    private static int partition(Purchase[] purchases, int low, int high) {
        Purchase pivot = purchases[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (purchases[j].getAmount() <= pivot.getAmount()) {
                i++;
                Purchase temp = purchases[i];
                purchases[i] = purchases[j];
                purchases[j] = temp;
            }
        }
        Purchase temp = purchases[i + 1];
        purchases[i + 1] = purchases[high];
        purchases[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Purchase[] purchases = {
            new Purchase(1, "Alice", 150.0),
            new Purchase(2, "Bob", 200.0),
            new Purchase(3, "Charlie", 100.0)
        };

        System.out.println("Before Sorting:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        // Bubble Sort
        bubbleSort(purchases);
        System.out.println("\nAfter Bubble Sort:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        // Reinitialize the array for demonstration purposes
        purchases = new Purchase[]{
            new Purchase(1, "Alice", 150.0),
            new Purchase(2, "Bob", 200.0),
            new Purchase(3, "Charlie", 100.0)
        };

        // Quick Sort
        quickSort(purchases, 0, purchases.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
}
