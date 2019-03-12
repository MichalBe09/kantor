package material;

import java.net.URL;
import static material.Currency.*;
public class Main {
    public static void main(String[] args) {
        //CurrencyConverter cc = new CurrencyConverter();
//        CurrencyConverter.convert(Currency.PLN, Currency.GBP);

        ExchangeOffice exchangeOffice = new ExchangeOffice(1000);
        System.out.println();
        exchangeOffice.exchange(200, EUR, PLN,"760cce82768accf60bd5" );
        exchangeOffice.showFunds();

        exchangeOffice.exchange(30, PLN, CZK,"760cce82768accf60bd5");
        exchangeOffice.addMoney(PLN, 239.65);
        exchangeOffice.showFunds();


    }
}
