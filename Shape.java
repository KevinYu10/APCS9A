package APCSUnit9;
// import java.util.*;
public class Shape {
    public static void main(String[] args) {
        Triangle tr = new Triangle("red", false, 5, 8, 7);
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle("blue", false, 5);
        shapes[1] = new Rectangle("yellow", false, 4, 7);
        shapes[2] = new Triangle("red", false, 3, 4, 5);
        shapes[3] = new Square("green", false, 0);
        shapes[4] = new Pentagon("black", false, 5);
        shapes[5] = new House("purple", false, 6);
        System.out.println(shapes[0].calculatePerimeter());
        System.out.println(shapes[4].calculateArea());
    }
    private String color;
    private boolean filled;
    public Shape(String c, boolean f) {
        color = c;
        filled = f;
    }
    public double calculateArea() {
        return 0;
    }
    public double calculatePerimeter() {
        return 0;
    }
    public void displayInfo() {
        if(filled) {
            System.out.println("The shape is filled");
        } else {
            System.out.println("The shape is not filled");
        }
        System.out.println("The color of the shaper is "+color);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String c) {
        color = c;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean f) {
        filled = f;
    }
}

class Triangle extends Shape {

    double sideOne;
    double sideTwo;
    double sideThree;
    public Triangle(String color, boolean filled, double sideOne, double sideTwo, double sideThree) {
        super(color, filled);
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }
    @Override
    public double calculateArea() {
        double s = (sideOne + sideTwo + sideThree)/2;
        return Math.sqrt(s*(s-sideOne)*(s-sideTwo)*(s-sideThree));
    }
    @Override
    public double calculatePerimeter() {
        return sideOne + sideTwo + sideThree;
    }
    public double getSideOne() {
        return sideOne;
    }
    public void setSideOne(double s) {
        sideOne = s;
    }
    public double getSideTwo() {
        return sideTwo;
    }
    public void setSideTwo(double s) {
        sideTwo = s;
    }
    public double getSideThree() {
        return sideThree;
    }
    public void setSideThree(double s) {
        sideThree = s;
    }
}

class Circle extends Shape {

    private double radius;
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return Math.PI * radius * 2;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        radius = r;
    }
}

class Rectangle extends Shape {

    private double height;
    private double width;
    public Rectangle(String color, boolean filled, double height, double width) {
        super(color, filled);
        this.height = height;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return height * width;
    }
    @Override
    public double calculatePerimeter() {
        return (height+width)*2;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double l) {
        height = l;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double w) {
        width = w;
    }
}

class Square extends Shape {

    private double length;
    public Square(String color, boolean filled, double length) {
        super(color, filled);
        this.length = length;
    }
    @Override
    public double calculateArea() {
        return length * length;
    }
    @Override
    public double calculatePerimeter() {
        return length * 4;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double l) {
        length = l;
    }
}

class Pentagon extends Shape {

    private double length;
    public Pentagon(String color, boolean filled, double length) {
        super(color, filled);
        this.length = length;
    }
    @Override
    public double calculateArea() {
        return (5*Math.pow(length, 2))/(4*Math.tan(Math.PI/5));
    }
    @Override
    public double calculatePerimeter() {
        return length*5;
    }
    public void setLength(double l) {
        length = l;
    }
    public double getLength() {
        return length;
    }   
}

class House extends Shape {

    private double length;
    private String color;
    private boolean filled;
    Triangle t = new Triangle(color, filled, length, length, length);
    Square s = new Square(color, filled, length);
    public House(String color, boolean filled, double length) {
        super(color, filled);
        this.length = length;
        this.filled = filled;
        this.color = color;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double l) {
        length = l;
    }
    @Override
    public double calculateArea() {
        return t.calculateArea() + s.calculateArea();
    }
    @Override
    public double calculatePerimeter() {
        return t.calculatePerimeter() + s.calculatePerimeter()-length;
    }
}