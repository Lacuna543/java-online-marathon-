package Sprint08.task1;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {


    Thread thread = new Thread();
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
        thread.start();
    }

}


