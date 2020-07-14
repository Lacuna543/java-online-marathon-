package Sprint06.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {

        return numbers.stream().filter(pr).reduce(Integer::max).get();

    }
}

public class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> predicate){
 return biFunction.apply(values, predicate);

    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

       return getFilterdValue(MyUtils::findMaxByCondition, predicate);

    }
}
