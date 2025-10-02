public class Main {
    public static void attemptToChangePrimitive(int val) {
        System.out.println("Inside method, parameter 'val' starts as: " + val);
        val = 99; // Local change
        System.out.println("Inside method, parameter 'val' is now: " + val);
    }
    public static void resetPoint(Point p) {
        p.move(0,0);
        p = new Point(0,0);
    }

    // Used for Exercise 5
    public static int sumCoordinates(Point... points) {
        int sum = 0;
        for (Point pt : points) {
            if (pt != null) sum += pt.x;

        }

        // Implementation needed for Exercise 5
        return sum;
    }

    public static void main(String[] args) {

        // --- Implement all exercises here ---
        Point startPoint = new Point(10, 20);
        System.out.println("startPoint.x = " + startPoint.x);
        startPoint.move(5, -3);
        startPoint.printState();

        // --- Exercise 2: Pass-by-value demonstration ---
        int originalValue = 50;
        attemptToChangePrimitive(originalValue);
        // originalValue remains 50 because Java passes arguments by value.
        System.out.println("After call, originalValue = " + originalValue);

        // Challenge: object reference behavior
        Point refPoint = new Point(7, 9);
        System.out.print("Before resetPoint, refPoint = ");
        refPoint.printState();
        resetPoint(refPoint);
        System.out.print("After resetPoint, refPoint = ");
        refPoint.printState();
        // Explanation in comments:
        // p.move(...) mutated the same object (visible to caller),
        // but 'p = new Point(...)' only changed the local parameter.

        // --- Exercise 3: constructor chaining test ---
        Point zeroPoint = new Point(); // should be (0, 0) via this(0)
        zeroPoint.printState();

        // --- Exercise 4: inheritance + super(...) ---
        Microwave m = new Microwave(800, 180); // 800W, 180s

        // --- Exercise 5: varargs calls (objects and array) ---
        int sumA = sumCoordinates(new Point(1, 1), new Point(2, 3), new Point(10, -5));
        System.out.println("Sum of x's (individual args) = " + sumA);

        Point[] arr = {new Point(4, 0), new Point(6, 8), new Point(-2, 5)};
        int sumB = sumCoordinates(arr);
        System.out.println("Sum of x's (array) = " + sumB);

        // --- Exercise 6: overriding ---
        m.printDescription();

        // --- Exercise 7: polymorphism (upcasting) ---
        Device d1 = new Device(500);
        Microwave m1 = new Microwave(1000, 120);
         // upcasting is implicit
        System.out.println("Output from Device d1:");
        d1.printDescription();
        Device polyDevice = m1;
        polyDevice.printDescription();
        // Which method runs? The overridden Microwave.printDescription()
        // because Java uses the object's *runtime type* for instance methods.

        // --- Exercise 8: safe downcasting ---
        // polyDevice.heatFood(); // <-- compile-time error (Device doesn't know heatFood)
        if (polyDevice instanceof Microwave) {
            Microwave casted = (Microwave) polyDevice;
            casted.heatFood();

        }


    }