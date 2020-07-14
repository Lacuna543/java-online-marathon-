package Sprint06.task1;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*public interface Predicate<T> {
    boolean test(T t);
}*/

public class MyUtils {

    public static void main(String[] args) {
        int cnt = getCount(new int[]{1, 2, 3, 4, 5}, (Integer x) -> x % 2 == 0);

        System.exit(0);
    }

    public static int getCount(int[] intArray, Predicate<Integer> predicate) {
        int count = 0;

        return (int) Arrays.stream(intArray)
                .boxed()
                .filter(predicate)
                .count();
    }

}