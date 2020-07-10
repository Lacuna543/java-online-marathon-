package Sprint09.task4;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static String readFile(String filename) {
    /*    byte[] encoded = filename.getBytes();
        String text = new String(encoded, "UTF-8");
        System.out.println("print: "+text);
        return text;*/
        String temp = "";
        String toInt = "";
        try {
            FileReader newFileReader = new FileReader(filename);
            int c = 0;
            while ((c = newFileReader.read()) != -1) {
                temp += (char) c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int index = 0; index < temp.length(); index += 7) {
            String newTemp = temp.substring(index, index + 7);
            toInt += (char)Integer.parseInt(newTemp, 2);

        }
        return toInt;
    }
}
