public class CurrencyRate {
    private int currencyID;
    private String currencyCode;
    private double exchangeRate;

    public CurrencyRate(int currencyID, String currencyCode, double exchangeRate) {
        this.currencyID = currencyID;
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyID=" + currencyID +
                ", currencyCode='" + currencyCode + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
