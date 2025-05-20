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

    public ResultSet executeQuery(String query) throws ParserConfigurationException, IOException, SAXException {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String sql = query;
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            logging.Write(e.getMessage());
            return null;
        }
    }

    public void executeStatement(String statement) {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String sql = statement;
            stmt.execute(sql);
        } catch (SQLException e) {
            logging.Write(e.getMessage());
        }
    }
}

