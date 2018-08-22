package uk.co.michaeloldroyd.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
    @RequestMapping("/")
    public ResponseEntity<String> exampleRequest() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
