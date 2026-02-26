/**
 * The Square class models a square, subclass of Rectangle.
 * A square is a rectangle with equal width and length.
 */
public class Square extends Rectangle {

    // Constructors
    /** No-arg constructor: side=1.0 */
    public Square() {
        super(1.0, 1.0); // call Rectangle constructor with width=1.0, length=1.0
    }

    /** Constructor with given side */
    public Square(double side) {
        super(side, side); // call Rectangle constructor with width=side, length=side
    }

    /** Constructor with given side, color, and filled */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled); // call Rectangle constructor with all parameters
    }

    /** Get the side of the square (same as width and length) */
    public double getSide() {
        return getWidth(); // or getLength(), they are equal
    }

    /** Set the side of the square (sets both width and length) */
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    /** Override setWidth to maintain square geometry */
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width); // ensure length equals width
    }

    /** Override setLength to maintain square geometry */
    @Override
    public void setLength(double length) {
        super.setWidth(length); // ensure width equals length
        super.setLength(length);
    }

    /** Override toString to include square-specific information */
    @Override
    public String toString() {
        return (
            "A Square with side=" +
            getSide() +
            ", which is a subclass of " +
            super.toString()
        );
    }
}
