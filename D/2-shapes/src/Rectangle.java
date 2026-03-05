//*****************************************
// Rectangle.java
//
// Represents a rectangle.
//*****************************************

public class Rectangle extends Shape
{
    private double length; // in feet
    private double width;  // in feet

    //----------------------------------
    // Constructor: Sets up the rectangle.
    //----------------------------------
    public Rectangle(double l, double w)
    {
        super("Rectangle");
        length = l;
        width = w;
    }

    //------------------------------
    // Returns the area of the rectangle.
    //------------------------------
    @Override
    public double area()
    {
        return length * width;
    }

    //-----------------------------------
    // Returns the rectangle as a String.
    //-----------------------------------
    @Override
    public String toString()
    {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
