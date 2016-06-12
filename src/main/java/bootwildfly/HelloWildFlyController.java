package bootwildfly;

import java.net.InetAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController {

    @RequestMapping("hello")
    public String sayHello() {
        // Get server IP/host info
        String serverInfo = "";
        try {
            InetAddress inet = InetAddress.getLocalHost();
            String ip = inet.getHostAddress().toString();
            String hostname = inet.getHostName();
            serverInfo =  hostname + "/" + ip;
        } catch (java.net.UnknownHostException uhe) {
            serverInfo = uhe.toString();
        }

        // Get location info from ENV
        String location = System.getenv("CUSTOM_LOCATION");
        if ((location == null) || (location.length() == 0)) {
            location = "Maryland";
        }

        return ("Hello from " + location + " on server " + serverInfo);
      }
}
