/**
 * This class simulates a Regular Polygon by holding a number if sides, side length, and the center of the shape
 *
 * @author Alexander Melis
 * @version 1.0
 * @since 3/1/2026
 */

public class RegularPolygon {

    private int n;
    private double side, x, y;

    // No-arg constructor creates default values
    public RegularPolygon() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    // Creates RegularPolygon with given sides and side lengths at (0,0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }

    // Creates RegularPolygon of given sides and side lengths at given coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Setters amd Getters Section

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    // Calculates the perimeter of this RegularPolygon
    public double getPerimeter() {
        return side*n;
    }

    // Calculates the area of this RegularPolygon
    public double getArea() {
        return (n * side * side) / (4.0 * Math.tan(Math.PI / n));
    }

    // Custom toString method for displaying the output of this project efficiently;
    public String toString(int i) {
        return "Polygon " + i + " Perimeter: " + getPerimeter() + "\nPolygon " + i + " Area: " + getArea();
    }

}
