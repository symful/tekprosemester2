/**
 * The Rectangle class models a rectangle, subclass of Shape.
 */
public class Rectangle extends Shape {

    // Private instance variables
    private double width;
    private double length;

    // Constructors
    /** No-arg constructor: width=1.0, length=1.0, uses Shape's default constructor */
    public Rectangle() {
        super(); // call Shape default constructor
        this.width = 1.0;
        this.length = 1.0;
    }

    /** Constructor with given width and length, uses Shape's default constructor */
    public Rectangle(double width, double length) {
        super(); // call Shape default constructor
        this.width = width;
        this.length = length;
    }

    /** Constructor with given width, length, color, and filled */
    public Rectangle(
        double width,
        double length,
        String color,
        boolean filled
    ) {
        super(color, filled); // call Shape constructor with color and filled
        this.width = width;
        this.length = length;
    }

    // Getters and Setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /** Calculate area of rectangle: width * length */
    public double getArea() {
        return width * length;
    }

    /** Calculate perimeter of rectangle: 2 * (width + length) */
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /** Override toString to include rectangle-specific information */
    @Override
    public String toString() {
        return (
            "A Rectangle with width=" +
            width +
            " and length=" +
            length +
            ", which is a subclass of " +
            super.toString()
        );
    }
}
