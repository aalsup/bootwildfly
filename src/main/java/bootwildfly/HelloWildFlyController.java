package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController {


    @RequestMapping("hello")
    public String sayHello() {
        String location = System.getenv("CUSTOM_LOCATION");
        if ((location == null) || (location.length() == 0)) {
            location = "Maryland";
        }
        return ("Goodbye from " + location);
    }
}
