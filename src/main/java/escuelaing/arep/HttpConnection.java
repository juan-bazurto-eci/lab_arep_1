package escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase que proporciona una conexión HTTP para acceder a una API pública o privada.
 */
public class HttpConnection {
    private static final String USER_AGENT = "Mozilla/5.0 Chrome/51.0.2704.103 Safari/537.36";
    private static final String GET_URL = "https://www.omdbapi.com/?apikey=38733655&t=";

    /**
     * Realiza una solicitud HTTP GET a una API para obtener datos de una película.
     *
     * @param movie Título de la película para buscar en la API.
     * @return Respuesta de la API en formato JSON.
     * @throws IOException Si ocurre un error en la comunicación con la API.
     */
    public String getMovieData(String movie) throws IOException {
        URL obj = new URL(GET_URL + movie);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "{}";
    }
}
