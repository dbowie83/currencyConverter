import java.util.Map;
import java.util.TreeMap;

public class CurrencyConverter {

    public Double ConvertCurrency(String currencyFrom, String currencyTo, Double amount) throws Exception {
        if (amount <= 0 ) throw new Exception("Invalid amount: amount must be greater than 0");

        Database db = new Database();
        db.openConnection();

        Double fromExchangeRate = CurrencyDAO.find(db.getConnection(), currencyFrom).getExchangeRate();
        Double toExchangeRate =  CurrencyDAO.find(db.getConnection(), currencyTo).getExchangeRate();

        Double currencyFromInDollars = amount / fromExchangeRate;
        Double result = currencyFromInDollars * toExchangeRate;

        db.closeConnection(false);

        return result;
    }




}
