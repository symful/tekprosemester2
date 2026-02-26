public class TestCylinder {

    // save as "TestCylinder.java"
    public static void main(String[] args) {
        // Default cylinder
        Cylinder c1 = new Cylinder();
        System.out.println("c1 (initial): " + c1);
        System.out.println(
            "c1 details: radius=" +
                c1.getRadius() +
                " height=" +
                c1.getHeight() +
                " surfaceArea=" +
                c1.getArea() +
                " volume=" +
                c1.getVolume() +
                " color=" +
                c1.getColor()
        );

        // Use setters to change color and height
        c1.setColor("green");
        c1.setHeight(5.5);
        System.out.println("\nc1 (after setColor/setHeight): " + c1);
        System.out.println(
            "c1 details (after): radius=" +
                c1.getRadius() +
                " height=" +
                c1.getHeight() +
                " surfaceArea=" +
                c1.getArea() +
                " volume=" +
                c1.getVolume() +
                " color=" +
                c1.getColor()
        );

        // Cylinder created with radius, height and color
        Cylinder c2 = new Cylinder(2.5, 4.0, "blue");
        System.out.println("\nc2 (initial): " + c2);
        System.out.println(
            "c2 details: radius=" +
                c2.getRadius() +
                " height=" +
                c2.getHeight() +
                " surfaceArea=" +
                c2.getArea() +
                " volume=" +
                c2.getVolume() +
                " color=" +
                c2.getColor()
        );

        // Modify c2 using setters
        c2.setColor("yellow");
        c2.setHeight(10.0);
        System.out.println("\nc2 (after setColor/setHeight): " + c2);
        System.out.println(
            "c2 details (after): radius=" +
                c2.getRadius() +
                " height=" +
                c2.getHeight() +
                " surfaceArea=" +
                c2.getArea() +
                " volume=" +
                c2.getVolume() +
                " color=" +
                c2.getColor()
        );

        // Compare Circle.getArea() and Cylinder.getArea() (overridden)
        Circle circle = new Circle(3.0, "magenta");
        System.out.println("\nCircle instance: " + circle);
        System.out.println(
            "Circle.getArea() (base area) = " + circle.getArea()
        );
        System.out.println(
            "c2.getArea() (cylinder surface area - overridden) = " +
                c2.getArea()
        );
        System.out.println(
            "c2.getVolume() (uses super.getArea() internally) = " +
                c2.getVolume()
        );

        // Demonstrate exception on invalid height
        try {
            Cylinder invalid = new Cylinder(1.0, -2.0, "black");
            System.out.println("This should not print: " + invalid);
        } catch (IllegalArgumentException ex) {
            System.out.println(
                "\nCaught expected exception for negative height: " +
                    ex.getMessage()
            );
        }
    }
}
