package material;

import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    private Map<Currency, Double> avaibleFounds;

    // konstruktor zasilający obiekt w startowe wartości
    public ExchangeOffice(double startFounds) {
        this.avaibleFounds = new HashMap<>();
        for (Currency c : Currency.values()) {
            System.out.println(c + ", "); // iteracja po enum - waluty posiadane przez kantor
            avaibleFounds.put(c, startFounds); // zasilamy każdą walutę wartością z argumentu metody
        }
    }

    public void addMoney(Currency currency, double cash){
        for (Currency c: Currency.values()){
            if (c.getName().equals(currency.getName())){
                double rep = this.avaibleFounds.get(currency);
                rep+= rep + cash;
                this.avaibleFounds.replace(c, rep);
            }
        }
    }

    public void showFunds(){
        for (Map.Entry<Currency, Double> entry : avaibleFounds.entrySet()) {

            //sposob 1
//            Currency key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.println(value+" "+key.getName()+" ");

            //sposob 2
            System.out.println(entry.getValue()+" "+entry.getKey().getName());

        }
    }
    public void exchange (double amount, Currency from, Currency to, String apiKey){
        double avaible = avaibleFounds.get(to); // szukamy po kluczu, którym jest Currency
        double needed = amount * 0.8 * CurrencyConverter.convert(from,to, apiKey);

        if (avaible >= needed ){
            avaibleFounds.put(from,avaibleFounds.get(from)+amount);
            avaibleFounds.put(to,avaibleFounds.get(to) - needed);
            System.out.println("Exchanging "
                    +amount+" "
                    +from.getName()
                    + " to "
                    +needed
                    + " "
                    +to.getName()
            );
        }else {
            System.out.println("Cannot exchange"
                    +amount+" "
                    +from.getName()
                    + " to "
                    +needed
                    + " "
                    +to.getName()
                    +" Insufficient founds."




            );
        }


    }
}
