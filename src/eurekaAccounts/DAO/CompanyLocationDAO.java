package eurekaAccounts.DAO;

import eurekaAccounts.VO.CompanyLocationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CompanyLocationDAO extends BaseDAO {
    public ArrayList<CompanyLocationVO> getCompanyLocations(List<String> tickers) throws SQLException {
        Objects.requireNonNull(tickers, "tickers");
        ArrayList<CompanyLocationVO> locations = new ArrayList<>();
        if (tickers.isEmpty()) {
            return locations;
        }
        String placeholders = String.join(", ", Collections.nCopies(tickers.size(), "?"));
        String sql = "SELECT ticker_symbol, address, city, state, zip, country"
                + " FROM endeavour.company_locations WHERE ticker_symbol IN ("
                + placeholders + ") ORDER BY ticker_symbol";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(15);
            for (int index = 0; index < tickers.size(); index++) {
                statement.setString(index + 1, tickers.get(index));
            }
            try (ResultSet rows = statement.executeQuery()) {
                while (rows.next()) {
                    locations.add(new CompanyLocationVO(rows.getString("ticker_symbol"),
                            rows.getString("address"), rows.getString("city"),
                            rows.getString("state"), rows.getString("zip"),
                            rows.getString("country")));
                }
            }
        }
        return locations;
    }
}
