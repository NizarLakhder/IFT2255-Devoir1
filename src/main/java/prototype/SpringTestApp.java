package prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@RestController
public class SpringTestApp {

    @GetMapping("/")
    public String hello() {
        return "Spring Boot is working!";
    }
   
    @PostMapping("/avis")
    public String postMethodName(@RequestBody Avis avis ) {
        System.out.println("Avis reçu: " + avis);
        return " Avis reçu pour le cours " + avis.getCours();
        
       
    }
    @GetMapping("/avis")
public String testAvis() {
    return "This page only supports POST. Use Postman or your bot!";
}
    public static void main(String[] args) {
        SpringApplication.run(SpringTestApp.class, args);
    }
}