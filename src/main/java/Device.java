public class Device {
    public String model = "Generic Device";
    protected int powerLevel; // Protected members are inherited

    // Constructor that sets up the power when an object is created
    public Device(int startPower) {
        this.powerLevel = startPower;
        System.out.println("--- Device initialized. ---");
    }

    // lets us change the power safely by not letting negative numbers be entered
    public void setPower(int newLevel) {
        if (newLevel >= 0) {
            powerLevel = newLevel;
        }
    }

    // returns the info about the device
    public void printDescription() {
        System.out.println("Device Model: " + model + ", Current Power: " + powerLevel + " Watts.");
    }

}
