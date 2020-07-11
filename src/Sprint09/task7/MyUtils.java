package Sprint09.task7;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Set<Integer> set = new HashSet<>();
        return stream.filter(Objects::nonNull).filter(x -> !set.add(x))
                .distinct()
                .sorted(Integer::compareTo);
    }
}
