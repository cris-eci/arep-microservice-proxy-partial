package co.edu.eci.arep.proxy;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class ProxyController {

    private final String instance1 = System.getenv("INSTANCE1_URL") != null ? System.getenv("INSTANCE1_URL") : System.getenv("http://:localhost:8081");
    private final String instance2 = System.getenv("INSTANCE2_URL") != null ? System.getenv("INSTANCE2_URL") : System.getenv("http://:localhost:8082");

}
