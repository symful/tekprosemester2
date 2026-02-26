/**
 * The Shape class models a shape with color and filled properties.
 */
public class Shape {

    // Private instance variables
    private String color;
    private boolean filled;

    // Constructors
    /** No-arg constructor: initializes color to "green" and filled to true */
    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    /** Constructor with given color and filled */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Getter and Setter for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and Setter for filled (using isFilled() convention for boolean)
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Returns a string representation of the Shape */
    @Override
    public String toString() {
        String filledStatus = filled ? "filled" : "Not filled";
        return "A Shape with color of " + color + " and " + filledStatus;
    }
}
