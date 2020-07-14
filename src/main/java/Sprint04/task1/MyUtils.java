package Sprint04.task1;

import java.util.*;

public class MyUtils {
    // Code
    public static void main(String[] args) {


        Map<String, String> phones = new HashMap<String, String>() {{
            put("0967654321", "Petro");
            put("0677654321", "Petro");
            put("0501234567", "Ivan");
            put("0970011223", "Stepan");
            put("0631234567", "Ivan");
            put("bad", null);
            put(null, null);
        }};

    }

    public Map<String, List<String>> createNotebook(Map<String, String> phones) { //входащая
        Map<String, List<String>> map = new HashMap<>();  //результ, [имя, список телефонов]

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (map.containsKey(entry.getValue())) {
                map.get(entry.getValue()).add(entry.getKey());
            } else {
                map.put(entry.getValue(), new ArrayList<>(Collections.singleton(entry.getKey())));

                //приходят одинаковые ключи - замена значения (запихнуть в лист)
                // Нeт ключа - возвр. нулл

            }
        }
        return map;
    }
}

