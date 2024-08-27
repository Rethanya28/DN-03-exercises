import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Item class to represent each item in the inventory
class Item {
    private int id;
    private String name;
    private int stock;
    private double cost;

    // Constructor to initialize item attributes
    public Item(int id, String name, int stock, double cost) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    // Getters and setters for item attributes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item[ID=" + id + ", Name=" + name + ", Stock=" + stock + ", Cost=" + cost + "]";
    }
}

// StockManager class to manage the collection of items
class StockManager {
    private Map<Integer, Item> inventory;

    // Constructor initializes the inventory map
    public StockManager() {
        inventory = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        if (inventory.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item ID already exists.");
        }
        inventory.put(item.getId(), item);
    }

    // Method to update item details
    public void updateItem(int id, Integer stock, Double cost) {
        Item item = inventory.get(id);
        if (item == null) {
            throw new IllegalArgumentException("Item not found.");
        }
        if (stock != null) {
            item.setStock(stock);
        }
        if (cost != null) {
            item.setCost(cost);
        }
    }

    // Method to delete an item from the inventory
    public void removeItem(int id) {
        if (!inventory.containsKey(id)) {
            throw new IllegalArgumentException("Item not found.");
        }
        inventory.remove(id);
    }

    // Method to retrieve an item by its ID
    public Item getItem(int id) {
        return inventory.get(id);
    }

    // Method to display all items in the inventory
    public void showItems() {
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
    }
}

// Main class containing the entry point of the application
public class InventoryApp {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        Scanner scanner = new Scanner(System.in);

        // Infinite loop to keep the program running until user decides to exit
        while (true) {
            // Display menu options to the user
            System.out.println("Inventory Management System:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Remove Item");
            System.out.println("4. View Item");
            System.out.println("5. Show All Items");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            // Switch case to handle the user's choice
            switch (option) {
                case 1:
                    // Adding a new item
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Stock: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter Cost: ");
                    double cost = scanner.nextDouble();
                    Item item = new Item(id, name, stock, cost);
                    manager.addItem(item);
                    break;
                case 2:
                    // Updating an existing item
                    System.out.print("Enter Item ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new Stock (or -1 to skip): ");
                    stock = scanner.nextInt();
                    System.out.print("Enter new Cost (or -1 to skip): ");
                    cost = scanner.nextDouble();
                    manager.updateItem(id, stock == -1 ? null : stock, cost == -1 ? null : cost);
                    break;
                case 3:
                    // Removing an item
                    System.out.print("Enter Item ID to remove: ");
                    id = scanner.nextInt();
                    manager.removeItem(id);
                    break;
                case 4:
                    // Viewing a specific item
                    System.out.print("Enter Item ID to view: ");
                    id = scanner.nextInt();
                    Item foundItem = manager.getItem(id);
                    if (foundItem != null) {
                        System.out.println(foundItem);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    // Showing all items
                    manager.showItems();
                    break;
                case 6:
                    // Exiting the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    // Handling invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
