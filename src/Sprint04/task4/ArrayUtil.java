package Sprint04.task4;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    public static <T> T setAndReturn(T[] arr, T val, int index) {

        return arr[index] = val;
    }
}
