import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyConverterTest {
    CurrencyConverter currencyConverter;

    @BeforeEach
    @DisplayName("Set Up")
    public void setup(){
        currencyConverter = new CurrencyConverter();
    }


    //example data format
    // currencyID (int), currencyCode (3 letter String), exchangeRate (double)
    @Test
    @DisplayName("convertToDollars")
    public void toDollars(){
        try {
            Double result = currencyConverter.ConvertCurrency("arg", "usd", 10.0);
            Double expectedConversion = 0.028567347521782603;
            assertEquals(expectedConversion, result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("pesos to pounds")
    public void pesosToPounds(){
        try {
            Double result = currencyConverter.ConvertCurrency("arg", "eng", 10.0);
            Double expectedConversion = 0.023425224967861733;
            assertEquals(expectedConversion, result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("invalid amount")
    public void invalidAmount(){
        try {
            assertThrows(Exception.class, ()->currencyConverter.ConvertCurrency("arg", "eng", 0.0));
            assertThrows(Exception.class, ()->currencyConverter.ConvertCurrency("arg", "eng", -1.0));


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
