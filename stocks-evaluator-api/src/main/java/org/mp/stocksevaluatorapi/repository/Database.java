package org.mp.stocksevaluatorapi.repository;

import org.mp.stocksevaluatorapi.Configuration;
import org.mp.stocksevaluatorapi.Logging;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;

public class Database {

    private String connectionString;
    private Logging logging;

    public Database() throws ParserConfigurationException, IOException, SAXException {
        Configuration cfg = new Configuration();
        connectionString = cfg.GetDatabaseConnectionString();
        logging = new Logging();
    }

    public String GetStock() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String sql = "SELECT Company FROM Stock";
            ResultSet rs = stmt.executeQuery(sql);
            String company = "";

            if (rs.next()) {
                company = rs.getString("Company");
            }

            return company;
        } catch (SQLException e) {
            logging.Write(e.getMessage());
            return null;
        }
    }
}

