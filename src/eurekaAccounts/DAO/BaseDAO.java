package eurekaAccounts.DAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO {
    protected Connection openConnection() throws SQLException {
        Properties settings = new Properties();
        try (Reader reader = Files.newBufferedReader(Path.of("db.properties"))) {
            settings.load(reader);
        } catch (IOException exception) {
            throw new SQLException("Cannot read db.properties from the project root.", exception);
        }
        DriverManager.setLoginTimeout(15);
        return DriverManager.getConnection(settings.getProperty("jdbc.url"),
                settings.getProperty("jdbc.user"), settings.getProperty("jdbc.password"));
    }
}
