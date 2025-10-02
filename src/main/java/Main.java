public class Main {

    public static void attemptToChangePrimitive(int val) {
        System.out.println("Inside method, parameter 'val' starts as: " + val);
        val = 99; // Local change
        System.out.println("Inside method, parameter 'val' is now: " + val);
    }

    // Challenge for Exercise 2
    public static void resetPoint(Point p) {
        // Mutates the same object (visible to caller)
        p.move(0, 0);

        // Reassigns only the local parameter (NOT visible to caller)
        p = new Point(0, 0);
    }

    // Exercise 5
    public static int sumCoordinates(Point... points) {
        int sum = 0;
        if (points != null) {
            for (Point pt : points) {
                if (pt != null) sum += pt.x;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // --- Exercise 1: Object creation & state access (Point) ---
        Point startPoint = new Point(10, 20);
        System.out.println("startPoint.x = " + startPoint.x);
        startPoint.move(5, -3);
        startPoint.printState();

        // --- Exercise 2: Pass-by-value with primitive and reference ---
        int originalValue = 50;
        attemptToChangePrimitive(originalValue);
        System.out.println("After call, originalValue = " + originalValue); // remains 50

        Point refPoint = new Point(7, 9);
        System.out.print("Before resetPoint, refPoint = ");
        refPoint.printState();
        resetPoint(refPoint);
        System.out.print("After resetPoint, refPoint = ");
        refPoint.printState();
        // Note: mutation is visible; reassignment inside method is not.

        // --- Exercise 3: Constructor chaining test (Point()) -> this(0) ---
        Point zeroPoint = new Point();
        System.out.print("Zero point should be (0, 0): ");
        zeroPoint.printState();

        // --- Exercise 4: Inheritance constructor call tested via Microwave ---
        Microwave m = new Microwave(800, 180); // 800W, 180s

        // --- Exercise 5: Varargs calls (individual Points and an array) ---
        int sumA = sumCoordinates(new Point(1, 1), new Point(2, 3), new Point(10, -5));
        System.out.println("Sum of x's (individual args) = " + sumA);
        Point[] arr = { new Point(4, 0), new Point(6, 8), new Point(-2, 5) };
        int sumB = sumCoordinates(arr);
        System.out.println("Sum of x's (array) = " + sumB);

        // --- Exercise 6: Overriding ---
        m.printDescription();

        // --- Exercise 7: Polymorphism (Upcasting) + actually use d1 ---
        Device d1 = new Device(500);
        System.out.println("\nOutput from Device d1 (before setPower):");
        d1.printDescription();

        // Use the setter so it's not “never used”
        d1.setPower(750);
        System.out.println("Output from Device d1 (after setPower to 750):");
        d1.printDescription();

        Microwave m1 = new Microwave(1000, 120);
        Device polyDevice = m1; // upcasting

        System.out.println("\nOutput from polyDevice (declared Device, actual Microwave):");
        polyDevice.printDescription();
        // Explanation: runtime type is Microwave, so overridden Microwave.printDescription() runs.

        // --- Exercise 8: Safe downcasting with instanceof ---
        // polyDevice.heatFood(); // compile error if uncommented (declared type is Device)
        if (polyDevice instanceof Microwave) {
            Microwave casted = (Microwave) polyDevice;
            casted.heatFood();
        }
    }
}