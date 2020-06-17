package Sprint02.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

interface Figure {
    double getPerimeter();
}

class Rectang implements Figure {
    private double width, height;

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectang rectang = (Rectang) o;
        return Double.compare(rectang.width, width) == 0 &&
                Double.compare(rectang.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}

class Square implements Figure {
    private double width;

    public double getPerimeter() {
        return width * 4;
    }

    public Square(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}

public class MyUtils {
    public double sumPerimeter(List<?> firures) {
        if (firures == null || firures.isEmpty()) {
            return 0;
        }
        List<Figure> list = new ArrayList<>();
        return list.stream().mapToDouble(Figure::getPerimeter).sum();

    }

}
