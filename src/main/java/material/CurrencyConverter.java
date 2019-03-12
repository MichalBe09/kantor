package material;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConverter {


        public static double convert(Currency from, Currency to, String apiKey) {
            try {
                URL url = new URL("https://free.currencyconverterapi.com/api/v6/convert?q="
                        + from.getName()
                        + "_"
                        + to.getName()
                        + "&compact=ultra&apiKey="
                        +apiKey); //metoda laduje ta strone intenetowa

//                System.out.println(url);


                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = reader.readLine();
//                System.out.println(line);
                reader.close();
                if (line.length() > 0) {
                    int startIndex = line.indexOf(':') + 1;
                    int endIndex = line.indexOf('}');
                    String value = line.substring(startIndex, endIndex);
                    return Double.parseDouble(value);
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

            return 0;
        }
    }


