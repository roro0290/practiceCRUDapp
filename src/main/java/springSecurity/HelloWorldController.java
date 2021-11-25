package springSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "hello world!";
    }

    @GetMapping("/helloUser")
    public String helloUser(){
        return "hello user!";
    }

    @GetMapping("/goodbyeUser")
    public String goodbyeUser(){
        return "goodbye user!";
    }
}
