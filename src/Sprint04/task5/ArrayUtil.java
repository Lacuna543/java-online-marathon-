package Sprint04.task5;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

public class ArrayUtil {
    public static <T extends Number> double averageValue(Array<T> array) {
        double average = 0;

        for (int i = 0; i < array.length(); i++) {
            average += array.get(i).doubleValue();
        }
        return average = average / array.length();


    }
}
