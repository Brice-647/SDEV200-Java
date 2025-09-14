import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortPoints {
    public static void main(String[] args) {
        // Step 1: Create an array of 100 random points
        Point2D.Double[] points = new Point2D.Double[100];
        Random rand = new Random();
        
        for (int i = 0; i < points.length; i++) {
            double x = rand.nextDouble() * 100; // range 0–100
            double y = rand.nextDouble() * 100;
            points[i] = new Point2D.Double(x, y);
        }
        
        // Step 2: Sort by y, then by x
        Arrays.sort(points, new Comparator<Point2D.Double>() {
            @Override
            public int compare(Point2D.Double p1, Point2D.Double p2) {
                int result = Double.compare(p1.getY(), p2.getY());
                if (result == 0) {
                    result = Double.compare(p1.getX(), p2.getX());
                }
                return result;
            }
        });
        
        // Step 3: Display the first five points
        System.out.println("First five sorted points (x, y):");
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%.2f, %.2f)%n", points[i].getX(), points[i].getY());
        }
    }
}