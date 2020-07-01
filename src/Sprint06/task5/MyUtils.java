package Sprint06.task5;

import java.util.function.Predicate;
import java.util.Set;

public class MyUtils {
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet){
        return predicateSet.stream().reduce(Predicate::and).get();
    }
}
