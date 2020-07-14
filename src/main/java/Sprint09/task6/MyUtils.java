package Sprint09.task6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Stream<String> stringStream = Stream.empty();
        Map<String, Stream<String>> newMap = new HashMap<>();
        if (list == null) {
            return null;
        }
        for (Stream<String> stream : list) {
            if (stream != null)
                stringStream = Stream.concat(stringStream, stream)
                        .filter(Objects::nonNull)
                        .map(x -> x.replaceAll("[()]*[ ]*[-]*", ""))
                        .filter(x -> !x.isEmpty());

        }
        List<String> phoneNumber = stringStream.collect(toList());
        if (phoneNumber.stream().anyMatch(x -> x.length() == 10)) {
            newMap = phoneNumber.stream().filter(x -> x.length() == 10)
                    .distinct()
                    .collect(Collectors.groupingBy(x -> x.substring(0, 3), Collectors.mapping(x -> x.substring(3), toList())))
                    .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, x -> x.getValue().stream().sorted()));
        }
        if (phoneNumber.stream().anyMatch(x -> x.length() < 7)) {
            newMap.put("err", phoneNumber.stream().filter(x -> x.length() < 7).distinct().sorted());
        }
        if (phoneNumber.stream().anyMatch(x -> x.length() == 7)) {
            newMap.put("loc", phoneNumber.stream().filter(x -> x.length() == 7).distinct().sorted());
        }
        return newMap;
    }
}

