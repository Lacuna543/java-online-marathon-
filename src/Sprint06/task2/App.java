package Sprint06.task2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    static Consumer<double[]> cons = (doubleArray) -> {


        for (int i = 0; i < doubleArray.length; i++) {

            if (doubleArray[i] > 2.0) {
                doubleArray[i] *= 0.8;
            } else
                doubleArray[i] *= 0.9;
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
        double[] doublesNewArray = new double[initialArray.length];
        System.arraycopy(initialArray, 0, doublesNewArray, 0, initialArray.length);
        cons.accept(doublesNewArray);
        return doublesNewArray;
        // return Arrays.stream(initialArray).filter(cons)
    }
}
