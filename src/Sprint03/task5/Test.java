package Sprint03.task5;

enum ClientType {
    NEW(0), SILVER(12), GOLD(30), PLATINUM(60);

    private int months;

    ClientType(int months) {
        this.months = months;
    }

    public double discount() {
        double discount = (100 - months * 0.35) / 100;
        if (discount >= 0 && discount <= 1.0) {
            return discount;
        } else
            return -1;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(ClientType.NEW.discount());
    }
}
