public class CarsAssemble {

    private static final double BASE_RATE = 221.0; // Base production rate per hour

    // Method to calculate production rate per hour
    public double productionRatePerHour(int speed) {
        if (!isValidSpeed(speed)) {
            return 0;
        }

        double efficiency = getEfficiency(speed);
        return speed * efficiency * BASE_RATE;
    }

    // Method to calculate working items per minute
    public int workingItemsPerMinute(int speed) {
        return (int) Math.floor(productionRatePerHour(speed) / 60); // Ensuring correct rounding
    }

    // Helper method to determine efficiency based on speed (Traditional Switch-Case)
    private double getEfficiency(int speed) {
        switch (speed) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 1.0;   // 100% efficiency
            case 5:
            case 6:
            case 7:
            case 8:
                return 0.9;   // 90% efficiency
            case 9:
                return 0.8;   // 80% efficiency
            case 10:
                return 0.77;  // Corrected efficiency for speed 10
            default:
                return 0.0;   // Speed 0 or invalid
        }
    }

    // Validate speed range
    private boolean isValidSpeed(int speed) {
        return speed >= 0 && speed <= 10;
    }
}
