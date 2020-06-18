package Sprint03.task1;

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;


    private Pizza() {

    }


    public String getCheese() {
        return cheese;
    }

    public String getMeat() {
        return meat;
    }

    public String getSeafood() {
        return seafood;
    }

    public String getVegetable() {
        return vegetable;
    }

    public String getMushroom() {
        return mushroom;
    }


    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    // Describe PizzaBuilder class here
    public static class PizzaBuilder extends Pizza {

        private Pizza pizza;


        private PizzaBuilder() {
            super();
        }

        public PizzaBuilder addCheese(String chesse) {
            pizza.cheese = chesse;
            return PizzaBuilder.this;
            //повертати посилання на сконструйований об'єкт типу PizzaBuilder
        }

        public PizzaBuilder addMeat(String meat) {
            pizza.meat = meat;
            return PizzaBuilder.this;

        }

        public PizzaBuilder addSeafood(String seafood) {
            pizza.seafood = seafood;
            return PizzaBuilder.this;
        }

        public PizzaBuilder addVegetable(String vegetable) {
            pizza.vegetable = vegetable;
            return PizzaBuilder.this;
        }

        public PizzaBuilder addMushroom(String mushroom) {
            pizza.mushroom = mushroom;
            return PizzaBuilder.this;
        }
    }

}

class Oven {
    public static Pizza cook() {

        // Create and return instance of Pizza class here

        return Pizza.base().addCheese("Dor Blue").addSeafood("Shrimps").addVegetable("Tomato");

    }
}


