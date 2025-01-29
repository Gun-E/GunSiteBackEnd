package site.gun.springserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
