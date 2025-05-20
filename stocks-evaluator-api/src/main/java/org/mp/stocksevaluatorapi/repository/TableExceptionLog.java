package org.mp.stocksevaluatorapi.repository;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.ResultSet;

public class TableExceptionLog {

    private Database database;

    public TableExceptionLog() throws ParserConfigurationException, IOException, SAXException {
        database = new Database();
    }

    public void insertExceptionLog(String exception, String stackTrace) {
        database.executeStatement("EXECUTE ExceptionLogInsert '" + exception + "', '" + stackTrace + "'");
    }
}
