public class Cylinder extends Circle {

    // Save as "Cylinder.java"
    private double height; // private variable

    /**
     * Primary constructor
     * @param radius radius of base circle
     * @param height height of the cylinder (must be >= 0)
     * @param color color of the base circle / cylinder
     */
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // gunakan konstruktor Circle yang sesuai
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        this.height = height;
    }

    // Overloaded constructors chain to primary
    public Cylinder() {
        this(1.0, 1.0, "red");
    }

    public Cylinder(double height) {
        this(1.0, height, "red");
    }

    public Cylinder(double radius, double height) {
        this(radius, height, "red");
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        this.height = height;
    }

    /**
     * Overriding getArea() to return the surface area of the cylinder.
     * Surface area = 2 * base area + lateral surface area
     * = 2 * (pi r^2) + (2 pi r h)
     *
     * Note: super.getArea() returns the base area (pi r^2) from Circle.
     */
    @Override
    public double getArea() {
        double baseArea = super.getArea(); // π r^2
        double lateral = 2 * Math.PI * getRadius() * height; // 2 π r h
        return 2 * baseArea + lateral;
    }

    /**
     * Compute volume of the cylinder.
     * Important: call super.getArea() to obtain base area (π r^2),
     * otherwise calling getArea() here would use the overridden
     * getArea() (surface area) and give incorrect volume.
     */
    public double getVolume() {
        return super.getArea() * height; // base area * height
    }

    /**
     * Override toString() to include Cylinder-specific information
     * and reuse Circle's toString() via super.toString().
     */
    @Override
    public String toString() {
        return (
            "Cylinder: subclass of " + super.toString() + " height=" + height
        );
    }
}
