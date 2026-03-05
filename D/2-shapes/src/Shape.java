//*****************************************
// Shape.java
//
// Abstract base class for shapes.
//*****************************************

public abstract class Shape
{
    protected String shapeName;

    //----------------------------------
    // Constructor: Sets up the shape.
    //----------------------------------
    public Shape(String name)
    {
        shapeName = name;
    }

    //----------------------------------
    // Returns the area of the shape.
    //----------------------------------
    public abstract double area();

    //----------------------------------
    // Returns the shape name as a String.
    //----------------------------------
    @Override
    public String toString()
    {
        return shapeName;
    }
}
