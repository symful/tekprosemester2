/**
 * The Circle class models a circle, subclass of Shape.
 */
public class Circle extends Shape {

    // Private instance variable
    private double radius;

    // Constructors
    /** No-arg constructor: radius = 1.0, uses Shape's default constructor */
    public Circle() {
        super(); // call Shape default constructor (color=green, filled=true)
        this.radius = 1.0;
    }

    /** Constructor with given radius, uses Shape's default constructor */
    public Circle(double radius) {
        super(); // call Shape default constructor
        this.radius = radius;
    }

    /** Constructor with given radius, color, and filled */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // call Shape constructor with color and filled
        this.radius = radius;
    }

    // Getter and Setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Calculate area of circle: π * r² */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /** Calculate perimeter (circumference) of circle: 2 * π * r */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** Override toString to include circle-specific information */
    @Override
    public String toString() {
        return (
            "A Circle with radius=" +
            radius +
            ", which is a subclass of " +
            super.toString()
        );
    }
}
