package utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {
    /**
     * Il prend une URL, lui ouvre un flux, lit le flux et renvoie le contenu du flux sous forme de chaîne
     *
     * @param url L'URL de l'API que vous souhaitez demander.
     * @return Une chaîne de données JSON.
     */
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
