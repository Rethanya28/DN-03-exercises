public class SingleInstanceExample {

    // AuditLog class implementing Singleton pattern
    public static class AuditLog {
        private static AuditLog singleInstance;

        private AuditLog() {
            // Private constructor to prevent instantiation
        }

        public static AuditLog getSingleInstance() {
            if (singleInstance == null) {
                singleInstance = new AuditLog();
            }
            return singleInstance;
        }

        public void writeLog(String logEntry) {
            System.out.println(logEntry);
        }
    }

    // Test the Singleton Implementation
    public static void main(String[] args) {
        AuditLog log1 = AuditLog.getSingleInstance();
        AuditLog log2 = AuditLog.getSingleInstance();

        log1.writeLog("This is a log entry from log1.");
        log2.writeLog("This is a log entry from log2.");

        if (log1 == log2) {
            System.out.println("Both log1 and log2 are the same instance.");
        } else {
            System.out.println("log1 and log2 are different instances.");
        }
    }
}
