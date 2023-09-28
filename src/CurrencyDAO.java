import java.sql.*;

public class CurrencyDAO {

    public static CurrencyRate find(Connection conn, String currencyCode) throws DataAccessException {
        //fixme: throw exception if currCode len != 3
        if (currencyCode.length() != 3) throw new DataAccessException("invalid currencyCode");

        ResultSet rs = null;
        String sql = "SELECT * FROM currency WHERE currencyCode = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, currencyCode);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new CurrencyRate(rs.getInt("currencyID"), rs.getString("currencyCode"), rs.getDouble("exchangeRate"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding rate");
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static void insert(Connection conn, AuthToken token) throws DataAccessException {
//        String sql = "INSERT INTO authTokens (authToken, userID) VALUES(?,?)";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            //Using the statements built-in set(type) functions we can pick the question mark we want
//            //to fill in and give it a proper value. The first argument corresponds to the first
//            //question mark found in our sql String
//            stmt.setString(1, token.getAuthString());
//            stmt.setInt(2, token.getUserID());
//
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new DataAccessException("Error: AuthToken already used. If this happens to you again your luck is so extreme you should consider buying lottery tickets");
//        }
//    }

//    public static void remove(Connection conn, String authToken) throws DataAccessException {
//        String sql = "DELETE FROM authTokens WHERE authToken = ?;";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setString(1, authToken);
//
//            stmt.executeUpdate();
//
//        } catch (SQLException e){
//            throw new DataAccessException("Error removing authToken: " + e.getMessage());
//        }
//    }

    public static void clear(Connection conn) throws DataAccessException {
        String sql = "TRUNCATE TABLE currency";
        try (Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            throw new DataAccessException("Error" + e.getMessage());
        }
    }
}
