package utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {
    public static String Requester(URL url) throws IOException {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        }
    }
}
