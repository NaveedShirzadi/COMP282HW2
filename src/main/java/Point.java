public class Point {
    public int x = 0; // stores the x value
    public int y = 0; // stores the y value

    // No-arg constructor
    public Point() {
        this(0);
        // Automatically provided if none defined
    }
    public Point(int size) {
        this.x = size;
        this.y = size;
    }

    // Constructor that sets both the x and y value to the same
    public Point(int x, int y) {
        // Shadowing resolution used here
        this.x = x;
        this.y = y;
    }
    // Changes to point by an amount
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }
    // prints out the final results
    public void printState() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }

}
