package task5;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair() {
        int[] array = {x, y};
        return array;
    }

    public double distance(int x, int y) {
        return Math.hypot((this.x - x), (this.y - y));
    }

    public double distance(Point point) {
       return distance(point.x, point.y);
    }

    public double distance() {
        return distance(new Point(0,0));
    }
}
