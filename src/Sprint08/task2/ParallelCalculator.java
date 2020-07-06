package Sprint08.task2;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {

    BinaryOperator<Integer> binaryOperator;
    private int operand1;
    private int operand2;
    public int result;

    @Override
    public void run() {
        result = binaryOperator.apply(operand1, operand2);
    }

    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2) {
        this.binaryOperator = binaryOperator;
        this.operand1 = operand1;
        this.operand2 = operand2;

    }

}

class Accountant {

    public static int sum(int x, int y) {
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        Thread thread = new Thread(new ParallelCalculator(binaryOperator, x, y));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x + y;

    }

}
