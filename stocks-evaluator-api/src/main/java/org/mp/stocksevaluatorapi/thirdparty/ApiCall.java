package org.mp.stocksevaluatorapi.thirdparty;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiCall {

    public ApiCall() {

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd);
            JSONObject json = new JSONObject(text);
            return json;
        } finally {
            is.close();
        }
    }

    public JSONObject readJsonFromUrlJackson(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd).substring(1);
            text = text.substring(0, text.length() - 1);
            JSONObject json = new JSONObject(text);
            return json;
        } finally {
            is.close();
        }
    }

    public String readJsonFromUrlAsString(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String text = readAll(rd).substring(1);
            text = text.substring(0, text.length() - 1);
            return text;
        } finally {
            is.close();
        }
    }
}
