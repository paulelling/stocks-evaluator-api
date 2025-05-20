package org.mp.stocksevaluatorapi.thirdparty;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import org.mp.stocksevaluatorapi.ExceptionLog;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class ApiCall {

    ExceptionLog exceptionLog = new ExceptionLog();

    public ApiCall() {
        exceptionLog = new ExceptionLog();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException, ParserConfigurationException, SAXException {
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd);
            JSONObject json = new JSONObject(text);
            return json;
        } catch (IOException ex) {
            exceptionLog.saveException(ex);
            return null;
        }
    }

    public JSONObject readJsonFromUrlJackson(String url) throws IOException, JSONException, ParserConfigurationException, SAXException {
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd).substring(1);
            text = text.substring(0, text.length() - 1);
            JSONObject json = new JSONObject(text);
            is.close();
            return json;
        } catch (Exception e) {
            exceptionLog.saveException(e);
            return null;
        }
    }

    public String readJsonFromUrlAsString(String url) throws IOException, JSONException, ParserConfigurationException, SAXException {
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd).substring(1);
            text = text.substring(0, text.length() - 1);
            return text;
        } catch (Exception e) {
            exceptionLog.saveException(e);
            return null;
        }
    }
}
