package Sprint02.task6;

import java.util.*;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    /*public double getArea(){
        if (getName().equals("Circle")){
            return  getCircleArea();
        } else{
            return getRectangleArea();
        }
    }*/
    public abstract double getArea();
}
class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
class Rectangle extends Shape {
    private double height, width;

    public Rectangle(String name, double height, double width) {
        super(name);
        this.height = height;
        this.width = width;
    }
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    @Override
    public double getArea() {
        return 2 * (height + width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.height, height) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        double maxCircleArea = shapes.stream().filter(Circle.class::isInstance).mapToDouble(Shape::getArea).max().orElse(0);

        double maxRectArea = shapes.stream().filter(Rectangle.class::isInstance).mapToDouble(Shape::getArea).max().orElse(0);

        Set<Shape> output = new HashSet<>();
        for (Shape s : shapes) {
            if (s instanceof Circle && s.getArea() == maxCircleArea
                    || s instanceof Rectangle && s.getArea() == maxRectArea) {
                output.add(s);
            }
        }
        return new ArrayList<>(output);
    }
}
