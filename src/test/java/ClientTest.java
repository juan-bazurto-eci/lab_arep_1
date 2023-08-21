import escuelaing.arep.Client;
import org.junit.Test;

import java.io.IOException;

public class ClientTest {

    @Test
    public void testConcurrentClientRequests() {
        int numThreads = 5;

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        Client.testServer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
