package Sprint06.task4;

import java.util.ArrayList;
import java.util.List;

class Person {

    String name;
    DecisionMethod goShopping = (product, discount) -> {
        if (product.equals("product1") && discount > 10) {
            return true;
        } else return false;
    };

    Person(String name) {
        this.name = name;
    }


}

@FunctionalInterface
interface DecisionMethod {
    public boolean decide(String name, int discount);
}

// Create DecisionMethod interface here

public class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {

        int count;
        return (int) clients.stream().filter(clients -> clients.decide(product, percent)).count();
    }
}
