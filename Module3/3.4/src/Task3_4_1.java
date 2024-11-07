import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Task3_4_1 {
    public static void main(String[] args) {
        // first, create the url
        URL myUrl;
        String[] columnNames;
        boolean header = true;
        ArrayList<String> result = new ArrayList<>();
        try {
            myUrl = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            // open the connection and get the input stream
            // it will automatically generate HTTP GET-request
            InputStream istream = myUrl.openStream();

            // jump to character streams
            InputStreamReader istreamreader = new InputStreamReader(istream);

            // and to buffered reader for efficiency
            BufferedReader reader = new BufferedReader(istreamreader);

            // we use StringBuilder for efficiency, concatenating ordinary Strings is slow and
            // generates unnecessary objects
            String line;

            // here we read the content of the web page line by line
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

            // now it is time to print the result
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        String[] rows;
        int aikaIndex = 0;
        int ulkotaloIndex = 0;
        double sumOfTemps = 0;
        double averageTemp = 0;
        String[] date = new String[1];
        double amount = 0;

        for (String row : result) {
            if (header) {
                columnNames = row.split(";");
                for (int i = 0; i < columnNames.length; i++) {
                    if (columnNames[i].equals("Aika")) {
                        aikaIndex = i;
                    } else if (columnNames[i].equals("UlkoTalo")) {
                        ulkotaloIndex = i;
                    }
                }
                header = false;
            } else {
                rows = row.split(";");
                if (rows[aikaIndex].startsWith("01.01.2023")) {
                    String temp = rows[ulkotaloIndex].replace(",", ".");
                    date = rows[aikaIndex].split(" ");
                    amount++;
                    try {
                        sumOfTemps += Double.parseDouble(temp);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if (amount > 0) averageTemp = sumOfTemps / amount;
        if (amount == 0) System.out.println("No data for 01.01.2023 found");
        System.out.printf("The Average temp for %s is: %.2f celsius\n", date[0], averageTemp);
    }
}