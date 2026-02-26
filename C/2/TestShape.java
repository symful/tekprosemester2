/**
 * Test program for the Shape hierarchy.
 */
public class TestShape {

    public static void main(String[] args) {
        System.out.println("=== TESTING SHAPE CLASS ===\n");

        // Test Shape constructors and methods
        Shape s1 = new Shape();
        System.out.println("s1 (default): " + s1);

        Shape s2 = new Shape("blue", false);
        System.out.println("s2 (blue, false): " + s2);

        // Test setters
        s1.setColor("red");
        s1.setFilled(false);
        System.out.println("s1 after changes: " + s1);
        System.out.println("s1 color: " + s1.getColor());
        System.out.println("s1 isFilled? " + s1.isFilled());

        System.out.println("\n=== TESTING CIRCLE CLASS ===\n");

        // Test Circle constructors
        Circle c1 = new Circle();
        System.out.println("c1 (default): " + c1);
        System.out.println("c1 area: " + c1.getArea());
        System.out.println("c1 perimeter: " + c1.getPerimeter());

        Circle c2 = new Circle(2.5);
        System.out.println("\nc2 (radius=2.5): " + c2);
        System.out.println("c2 area: " + c2.getArea());
        System.out.println("c2 perimeter: " + c2.getPerimeter());

        Circle c3 = new Circle(3.0, "purple", false);
        System.out.println("\nc3 (radius=3.0, purple, false): " + c3);

        // Test setters
        c1.setRadius(5.0);
        c1.setColor("yellow");
        c1.setFilled(true);
        System.out.println("\nc1 after changes: " + c1);
        System.out.println("c1 radius: " + c1.getRadius());

        System.out.println("\n=== TESTING RECTANGLE CLASS ===\n");

        // Test Rectangle constructors
        Rectangle r1 = new Rectangle();
        System.out.println("r1 (default): " + r1);
        System.out.println("r1 area: " + r1.getArea());
        System.out.println("r1 perimeter: " + r1.getPerimeter());

        Rectangle r2 = new Rectangle(4.0, 5.0);
        System.out.println("\nr2 (width=4.0, length=5.0): " + r2);
        System.out.println("r2 area: " + r2.getArea());
        System.out.println("r2 perimeter: " + r2.getPerimeter());

        Rectangle r3 = new Rectangle(3.5, 6.0, "orange", true);
        System.out.println("\nr3 (width=3.5, length=6.0, orange, true): " + r3);

        // Test setters
        r1.setWidth(2.5);
        r1.setLength(7.0);
        r1.setColor("pink");
        System.out.println("\nr1 after changes: " + r1);

        System.out.println("\n=== TESTING SQUARE CLASS ===\n");

        // Test Square constructors
        Square sq1 = new Square();
        System.out.println("sq1 (default): " + sq1);
        System.out.println("sq1 side: " + sq1.getSide());
        System.out.println("sq1 area: " + sq1.getArea());
        System.out.println("sq1 perimeter: " + sq1.getPerimeter());

        Square sq2 = new Square(3.0);
        System.out.println("\nsq2 (side=3.0): " + sq2);
        System.out.println("sq2 width: " + sq2.getWidth());
        System.out.println("sq2 length: " + sq2.getLength());
        System.out.println("sq2 area: " + sq2.getArea());
        System.out.println("sq2 perimeter: " + sq2.getPerimeter());

        Square sq3 = new Square(4.5, "cyan", false);
        System.out.println("\nsq3 (side=4.5, cyan, false): " + sq3);

        System.out.println("\n=== TESTING SQUARE CONSISTENCY ===\n");

        // Test setSide
        sq1.setSide(2.0);
        System.out.println("sq1 after setSide(2.0): " + sq1);
        System.out.println(
            "sq1 width: " + sq1.getWidth() + ", length: " + sq1.getLength()
        );

        // Test overridden setters - they should maintain square geometry
        sq1.setWidth(5.0);
        System.out.println("\nsq1 after setWidth(5.0): " + sq1);
        System.out.println(
            "sq1 width: " + sq1.getWidth() + ", length: " + sq1.getLength()
        );

        sq1.setLength(7.0);
        System.out.println("\nsq1 after setLength(7.0): " + sq1);
        System.out.println(
            "sq1 width: " + sq1.getWidth() + ", length: " + sq1.getLength()
        );

        System.out.println("\n=== TESTING POLYMORPHISM ===\n");

        // Demonstrate polymorphism: Shape reference to Circle object
        Shape shapeRef = new Circle(2.0, "magenta", true);
        System.out.println("Shape reference to Circle: " + shapeRef.toString());
        // shapeRef.getArea() would not work unless casted, as Shape doesn't have getArea()

        // Demonstrate polymorphism: Rectangle reference to Square object
        Rectangle rectRef = new Square(3.5, "navy", false);
        System.out.println(
            "\nRectangle reference to Square: " + rectRef.toString()
        );
        System.out.println(
            "Area via Rectangle reference: " + rectRef.getArea()
        );
        System.out.println(
            "Perimeter via Rectangle reference: " + rectRef.getPerimeter()
        );

        // Cast to access Square-specific methods
        if (rectRef instanceof Square) {
            Square sq = (Square) rectRef;
            System.out.println("Side after casting: " + sq.getSide());
        }
    }
}
