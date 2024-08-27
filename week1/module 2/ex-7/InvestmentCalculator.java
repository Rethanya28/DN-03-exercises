class InvestmentCalculator {

    public static double computeFutureValue(double initialAmount, double interestRate, int timePeriods) {
        if (timePeriods == 0) {
            return initialAmount;
        }
        return (1 + interestRate) * computeFutureValue(initialAmount, interestRate, timePeriods - 1);
    }

    public static void main(String[] args) {
        double initialAmount = 1000;
        double interestRate = 0.05;
        int timePeriods = 10;

        double futureValue = computeFutureValue(initialAmount, interestRate, timePeriods);
        System.out.println("Future Value after " + timePeriods + " periods: " + futureValue);
    }
}
