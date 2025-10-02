public class Microwave extends Device { // declares microwave as a type of device
    private int maxTime;

    // Constructor that takes in the power and cooking time
    public Microwave(int startPower, int maxCookingTime) {
        super(startPower);      // superclass constructor call must be first
        this.maxTime = maxCookingTime;
    }

    // override printDescription to also show the maxTime(Exercise 6)
    @Override
    public void printDescription() {
        super.printDescription(); // call superclass first
        System.out.println("Max cooking time: " + maxTime + " seconds");
    }

    // new method for only the microwave (Exercise 8)
    public void heatFood() {
        System.out.println("Food is heating.");
    }
}

