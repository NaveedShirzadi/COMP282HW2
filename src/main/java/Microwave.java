public class Microwave extends Device {
    private int maxTime;

    // Constructor (Exercise 4)
    public Microwave(int startPower, int maxCookingTime) {
        super(startPower);      // superclass constructor call must be first
        this.maxTime = maxCookingTime;
    }

    // Override description (Exercise 6)
    @Override
    public void printDescription() {
        super.printDescription(); // call superclass first
        System.out.println("Max cooking time: " + maxTime + " seconds");
    }

    // Extra behavior (Exercise 8)
    public void heatFood() {
        System.out.println("Food is heating.");
    }
}

