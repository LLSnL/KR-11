import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        int c, i;
        List<Integer> k = new ArrayList<>();

        String filePath1 = "input.txt";
        String filePath2 = "output.txt";

        try (FileReader fileReader = new FileReader(filePath1)) {
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = fileReader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            String fileString = stringBuilder.toString();
            String[] strings = fileString.split(" ");
            ArrayList<Integer> numbers = new ArrayList<>();

            i = 0;
            for (String string : strings) {
                try {
                    Collections.addAll(k, Integer.parseInt(string));
                } catch (NumberFormatException e) {

                }
            }

            try (FileWriter fileWriter = new FileWriter(filePath2)) {
                for (Integer a: k) {
                    fileWriter.append(String.valueOf(a)).append(" ");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}