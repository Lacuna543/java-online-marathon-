package Sprint02.task2;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {
    String getName();
    DrinkReceipt addComponent(String componentName, int componentCount);
}
interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}
interface Rating {
    int getRating();
}
public class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        ingredients = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        new HashMap<String, Integer>();
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
new HashMap<String, Integer>() {{
            put("Water", 100);
            put("Arabica", 20);
        }};

   // addComponent("Water", 100).addComponent("Arabica",20);
        return ingredients;
    }

    @Override
    public int getRating() {
        return rating;
    }

}
class Espresso extends Caffee {


    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
   //  addComponent("Water", 50);
         Map<String, Integer> ingredients = new HashMap<String, Integer>() {{
            put("Water", 50);
            put("Arabica", 20);
        }};
    return ingredients;
    }
}
class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
      //  addComponent("Water", 50).addComponent("Milk", 50);
         Map<String, Integer> ingredients = new HashMap<String, Integer>() {{
            put("Water", 100);
            put("Arabica", 20);
            put("Milk", 50);
        }};
        return ingredients;
    }
}
 class MyUtils {
   /* Espresso espresso = new Espresso();
    Cappuccino cappuccino = new Cappuccino();
    Caffee caffee = new Caffee();*/
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        HashMap<String, ArrayList<Integer>> tmp = new HashMap<String, ArrayList<Integer>>();
        coffees.add(new Espresso("Espresso", 8));
        coffees.add(new Cappuccino("Cappuccino", 10));
        coffees.add(new Espresso("Espresso", 10));
        coffees.add(new Cappuccino("Cappuccino", 6));
        coffees.add(new Caffee("Caffee", 6));
        HashMap<String, Double> result = new HashMap<String, Double>();
        for (Map.Entry<String, ArrayList<Integer>> entry : tmp.entrySet()) {
            Double avg = 0.;
            for (Integer i : entry.getValue()) {
                avg += i;
            }
            avg /= entry.getValue().size();
            result.put(entry.getKey(), avg);
        }
        return result;
    }
}