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
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (n == 0) return 2;
        if (n == 1) return 1;
    
        long prev2 = 2; 
        long prev1 = 1; 
    
        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2; 
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    
}


