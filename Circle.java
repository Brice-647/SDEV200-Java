public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() { }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public int compareTo(Circle other) {
        if (other == null) throw new NullPointerException("other circle is null");
        return Double.compare(this.radius, other.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle other = (Circle) obj;
        return Double.compare(this.radius, other.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    public void printCircle() {
        System.out.println(
            "The circle is created " + getDateCreated()
            + " and the radius is " + radius
        );
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "blue", true);
        circle.printCircle();

        Circle a = new Circle(3.0);
        Circle b = new Circle(7.0);
        Circle c = new Circle(3.0);

        System.out.println("a.compareTo(b): " + a.compareTo(b)); // < 0
        System.out.println("a.compareTo(c): " + a.compareTo(c)); // == 0
        System.out.println("a.equals(c): " + a.equals(c));       // true
    }
}
