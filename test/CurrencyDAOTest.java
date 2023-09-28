import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyDAOTest {
    Database db = new Database();

    @BeforeEach
    public void setup() throws DataAccessException {
        db.openConnection();
    }

    @AfterEach
    public void tearDown() throws DataAccessException {
        db.closeConnection(false);
    }

    @Test
    public void findPass() throws DataAccessException {
        CurrencyRate rate = CurrencyDAO.find(db.getConnection(), "usd");
        assertEquals(1.0, rate.getExchangeRate());

        rate = CurrencyDAO.find(db.getConnection(), "eng");
        assertEquals(0.82, rate.getExchangeRate());

        rate = CurrencyDAO.find(db.getConnection(), "arg");
        assertEquals(350.05, rate.getExchangeRate());
    }

    @Test
    public void findFail() throws DataAccessException {
        assertNull(CurrencyDAO.find(db.getConnection(), "Joe"));
    }


    @Test
    public void invalidCurrencyCode() throws DataAccessException {
        assertThrows(DataAccessException.class, ()->CurrencyDAO.find(db.getConnection(), "e"));
    }
}
