package escuelaing.arep;

import java.io.IOException;

/**
 * Clase de prueba que simula múltiples hilos realizando solicitudes al servidor HTTP.
 */
public class Client {

    /**
     * Método principal para ejecutar las pruebas del servidor.
     */
    public static void main(String[] args) {
        int numThreads = 5;

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        testServer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * Realiza pruebas concurrentes al servidor.
     *
     * @throws IOException Si ocurre un error en la comunicación con el servidor.
     */
    public static void testServer() throws IOException {
        HttpConnection httpConnection = new HttpConnection();

        String[] movieTitles = {"Guardians of the Galaxy", "The Avengers", "Fast and Furious"};

        for (String movieTitle : movieTitles) {
            String response = httpConnection.getMovieData(movieTitle);
            System.out.println("Movie: " + movieTitle);
            System.out.println(response);
            System.out.println();
        }
    }
}

