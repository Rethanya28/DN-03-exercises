class Worker {
    private int id;
    private String fullName;
    private String role;
    private double earnings;

    public Worker(int id, String fullName, String role, double earnings) {
        this.id = id;
        this.fullName = fullName;
        this.role = role;
        this.earnings = earnings;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public double getEarnings() {
        return earnings;
    }

    @Override
    public String toString() {
        return "Worker[ID=" + id + ", Name=" + fullName + ", Role=" + role + ", Earnings=" + earnings + "]";
    }
}

public class WorkerManagement {
    private Worker[] workers;
    private int totalWorkers;

    public WorkerManagement(int capacity) {
        workers = new Worker[capacity];
        totalWorkers = 0;
    }

    public void addWorker(Worker worker) {
        if (totalWorkers < workers.length) {
            workers[totalWorkers++] = worker;
        } else {
            System.out.println("Worker list is full.");
        }
    }

    public Worker searchWorker(int id) {
        for (int i = 0; i < totalWorkers; i++) {
            if (workers[i].getId() == id) {
                return workers[i];
            }
        }
        return null;
    }

    public void removeWorker(int id) {
        for (int i = 0; i < totalWorkers; i++) {
            if (workers[i].getId() == id) {
                workers[i] = workers[totalWorkers - 1];
                workers[totalWorkers - 1] = null;
                totalWorkers--;
                return;
            }
        }
        System.out.println("Worker not found.");
    }

    public void displayWorkers() {
        for (int i = 0; i < totalWorkers; i++) {
            System.out.println(workers[i]);
        }
    }

    public static void main(String[] args) {
        WorkerManagement wm = new WorkerManagement(10);

        wm.addWorker(new Worker(1, "John Doe", "Developer", 50000));
        wm.addWorker(new Worker(2, "Jane Smith", "Manager", 60000));
        wm.addWorker(new Worker(3, "Emily Davis", "Designer", 55000));

        System.out.println("All Workers:");
        wm.displayWorkers();

        System.out.println("\nSearching for Worker with ID 2:");
        Worker foundWorker = wm.searchWorker(2);
        System.out.println(foundWorker != null ? foundWorker : "Worker not found");

        System.out.println("\nRemoving Worker with ID 2:");
        wm.removeWorker(2);
        wm.displayWorkers();
    }
}
