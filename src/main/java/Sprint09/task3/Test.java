package Sprint09.task3;


import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void writeFile(String filename, String text) {
        String newString = null;
        for (int i = 0; i < text.length(); i++) {
            String newBinaryChar = Integer.toBinaryString(text.charAt(i));

            while (newBinaryChar.length() < 7) {
                newBinaryChar = "0" + newBinaryChar;
            }
            newString += newBinaryChar;
        }
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(newString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}