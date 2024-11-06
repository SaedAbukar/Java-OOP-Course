import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Task3_4_2 {
    public static void main(String[] args) {
        ArrayList<Double> array = new ArrayList<Double>();

        for (int i = 0; i < 100; i++) {
            double result;
            if (array.size() >= 2) {
                result = array.get(i - 1) + array.get(i - 2);
                array.add(result);
            } else {
                array.add((double) i);
            }
        }
        try (Writer writer = new FileWriter("fibonacci.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int i = 0; i < 100; i++) {
                bufferedWriter.write(array.get(i) + ";");
            }
            // It is important to flush or close the writer to ensure the data is written to the file
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
