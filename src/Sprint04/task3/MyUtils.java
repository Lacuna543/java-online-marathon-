package Sprint04.task3;

import java.util.*;


public class MyUtils {
    // Code

    public boolean listMapCompare(List<String> list, Map<String, String> map) {

        map.values().removeAll(list);
        return map.isEmpty();

    }
}
