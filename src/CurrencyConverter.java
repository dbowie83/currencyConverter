import java.util.Map;
import java.util.TreeMap;

public class CurrencyConverter {
    Map<String, Double> exchangeRates;
    final Double englishPounds = 0.82;
    final Double argentinePesos = 350.05;

    CurrencyConverter(){
        //currencyCode (3 letter String), exchangeRate (double)

        exchangeRates = new TreeMap<>();
        exchangeRates.put("usd", 1.0);
        exchangeRates.put("eng", englishPounds);
        exchangeRates.put("arg", argentinePesos);
    }

    public Double ConvertCurrency(String currencyFrom, String currencyTo, Double amount) throws Exception {
        if (amount <= 0 ) throw new Exception("Invalid amount: amount must be greater than 0");
        Double fromExchangeRate = exchangeRates.get(currencyFrom);
        Double toExchangeRate = exchangeRates.get(currencyTo);

        Double currencyFromInDollars = amount / fromExchangeRate;
        Double result = currencyFromInDollars * toExchangeRate;
        return result;
    }
}
