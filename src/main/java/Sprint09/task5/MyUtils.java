package Sprint09.task5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;


public class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) throw new NullPointerException();
        Stream<String> stream = Stream.empty();


        for (Stream<String> s : map.values()) {
            if (s != null) {
                stream = Stream.concat(s, stream).distinct()
                        .filter(Objects::nonNull)
                        .map(x -> x.replaceAll(" ", ""))
                        .filter(objects -> !objects.isEmpty());
            } else
                return stream;

        }

        return stream.map(String::toLowerCase)
                .map(string -> string.substring(0, 1).toUpperCase() + string.substring(1))
                .distinct()
                .sorted(String::compareTo);

        //  Predicate<String> pattern = Pattern.compile("^[A-Z][a-z]*").asPredicate();

        //distinct()Повторные вхождения элементов
        //allMatch((s)-> s.startsWith("a")) - совпадение на символ
        //.filter(string -> !string.isEmpty()).count();


    }
}

class Main {
    public static void main(String[] args) {
        Map<String, Stream<String>> test = new HashMap<String, Stream<String>>() {{
            put("Desktop", Stream.of(" iVan", "PeTro ", " Ira "));
            put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na", null));
            put("Spring", Stream.of("Ivan", "Anna"));

        }};
        String[] res = new MyUtils().nameList(test).toArray(String[]::new);
        String[] expected = {"Andriy", "Anna", "Ira", "Ivan", "Petro", "Stepan"};
        boolean isOk = Arrays.equals(res, expected);
        System.out.println(isOk ? "OK" : "FAIL");
        if (!isOk) {
            System.out.println("Expected:");
            System.out.println(Arrays.toString(expected));
            System.out.println("But received:");
            System.out.println(Arrays.toString(res));
        }
    }
}