package org.mp.stocksevaluatorapi;

import org.mp.stocksevaluatorapi.repository.TableExceptionLog;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionLog {

    private String exception;
    private String stackTrace;

    public ExceptionLog() {

    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public void saveException(Exception e) throws ParserConfigurationException, IOException, SAXException {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stackTrace = sw.toString();
        TableExceptionLog tableExceptionLog = new TableExceptionLog();
        tableExceptionLog.insertExceptionLog(e.toString(), stackTrace);
    }

}
