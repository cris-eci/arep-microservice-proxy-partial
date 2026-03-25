package co.edu.eci.arep.mathservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class MathServiceController{
    @GetMapping("lucasseq")
    public String lucasseq(@RequestParam String value) {
        int n = Integer.parseInt(value);
        long result = computeLucasAlgorithm(n);
        return "{\"operation\":\"lucasseq\","
             + "\"input\":\"" + value + "\","
             + "\"output\":\"" + result + "\"}";
    }

    private long computeLucasAlgorithm(int n) {
        long b = 1;
        // if (n == 2) return 2;
        // if (n == 1) return 1;
        // if (n>=2){

        // }
        return b;
    }
}

// if (n <= 1) return n;
// long a = 0, b = 1;
// for (int i = 2; i <= n; i++) { long t = a+b; a = b; b = t; }
// return b;


// Secuencia de Lucas: 
// La secuencia de Lucas se calcula de la siguiente manera :
//  L(0)=2
// L(1)=1
// L(n)=L(n−1)+L(n−2)
// , para un n≥2

