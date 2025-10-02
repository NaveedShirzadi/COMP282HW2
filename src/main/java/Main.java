public class Main {

    public static void attemptToChangePrimitive(int val) {
        System.out.println("Inside method, parameter 'val' starts as: " + val);
        val = 99;
        System.out.println("Inside method, parameter 'val' is now: " + val);
    }

    // method to reset a point
    public static void resetPoint(Point p) {
        p.move(0, 0); // changes the same object
        p = new Point(0, 0); // changes the local copy
    }

    // adds up all the given x-coordinates
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
        //  Exercise 1:
        Point startPoint = new Point(10, 20);
        System.out.println("startPoint.x = " + startPoint.x);
        startPoint.move(5, -3);
        startPoint.printState();

        // Exercise 2
        int originalValue = 50;
        attemptToChangePrimitive(originalValue);
        System.out.println("After call, originalValue = " + originalValue); // remains 50

        Point refPoint = new Point(7, 9);
        System.out.print("Before resetPoint, refPoint = ");
        refPoint.printState();
        resetPoint(refPoint);
        System.out.print("After resetPoint, refPoint = ");
        refPoint.printState();


        // Exercise 3
        Point zeroPoint = new Point();
        System.out.print("Zero point should be (0, 0): ");
        zeroPoint.printState();

        // Exercise 4
        Microwave m = new Microwave(800, 180);

        // Exercise 5
        int sumA = sumCoordinates(new Point(1, 1), new Point(2, 3), new Point(10, -5));
        System.out.println("Sum of x's (individual args) = " + sumA);
        Point[] arr = { new Point(4, 0), new Point(6, 8), new Point(-2, 5) };
        int sumB = sumCoordinates(arr);
        System.out.println("Sum of x's (array) = " + sumB);

        // Exercise 6
        m.printDescription();

        // Exercise 7
        Device d1 = new Device(500);
        System.out.println("\nOutput from Device d1 (before setPower):");
        d1.printDescription();

        d1.setPower(750);
        System.out.println("Output from Device d1 (after setPower to 750):");
        d1.printDescription();

        Microwave m1 = new Microwave(1000, 120);
        Device polyDevice = m1;

        System.out.println("\nOutput from polyDevice (declared Device, actual Microwave):");
        polyDevice.printDescription();


        // Exercise 8

        if (polyDevice instanceof Microwave) {
            Microwave casted = (Microwave) polyDevice;
            casted.heatFood();
        }
    }
}