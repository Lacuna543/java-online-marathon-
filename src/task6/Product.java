package task6;

public class Product {
    private String name;
    private double price;
    static int tmp = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
        tmp++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        tmp++;
    }

    public static int count() {
        return tmp;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Pen", 2.75);
        Product p2 = new Product();
        Product p3 = new Product("Notebook", 8.25);
        int countIfProducts = Product.count();
        System.out.println("Was created " + countIfProducts + " new products!");
    }
}
