package Sprint03.task3;

interface Strategy {
    double doOperation(int a, int b);

}

public class Test {
    public static void main(String[] args) {
        int x = 6;
        int y = 3;
        addAtoB(x, y);
        subtractBfromA(x, y);
        multiplyAbyB(x, y);
        divideAbyB(x, y);
    }

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        execute(a, b, (a1, b1) -> a + b);

        Strategy add = new Strategy() {
            @Override
            public double doOperation(int a, int b) {

                return a + b;
            }
        };

    }

    public static void subtractBfromA(int a, int b) {
        execute(a, b, (a1, b1) -> a - b);

        Strategy sub = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        };

    }

    public static void multiplyAbyB(int a, int b) {
        execute(a, b, (a1, b1) -> a * b);
        Strategy multy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        };

    }

    public static void divideAbyB(int a, int b) {
        execute(a,b, (a1, b1) -> a/b);
        Strategy div = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a / b;
            }
        };

    }


}