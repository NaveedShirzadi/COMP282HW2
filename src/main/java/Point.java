public class Point {
    public int x = 0;
    public int y = 0;

    // Default Constructor (Exercise 3 modification needed here)
    public Point() {
        this(0);
        // Automatically provided if none defined
    }
    public Point(int size) {
        this.x = size;
        this.y = size;
    }

    // Two-argument constructor
    public Point(int x, int y) {
        // Shadowing resolution used here
        this.x = x;
        this.y = y;
    }

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public void printState() {

        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }

}
