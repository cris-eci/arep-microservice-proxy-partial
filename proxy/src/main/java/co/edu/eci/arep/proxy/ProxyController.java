package co.edu.eci.arep.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class ProxyController {

    private final String instance1 = System.getenv("INSTANCE1_URL") != null ? System.getenv("INSTANCE1_URL") : System.getenv("http://localhost:8081");
    private final String instance2 = System.getenv("INSTANCE2_URL") != null ? System.getenv("INSTANCE2_URL") : System.getenv("http://localhost:8082");

     @GetMapping("/proxy/lucasseq")
    public String lucasseq(@RequestParam String value) {
        return delegate("/lucasseq?value=" + value);
    }

    // active passive
    private String delegate(String path) {
        try {
            return callService(instance1 + path);
        } catch (Exception e) {
            try {
                return callService(instance2 + path);
            } catch (Exception e2) {
                return "{\"error\":\"all instances down\"}";
            }
        }
    }

    private String callService(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) response.append(line);
        in.close();
        return response.toString();
    }
}

