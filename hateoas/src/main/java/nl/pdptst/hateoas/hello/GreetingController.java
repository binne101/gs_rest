package nl.pdptst.hateoas.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;

import java.util.concurrent.atomic.AtomicLong;

@Configuration
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private FeatureManager manager;

    public GreetingController(FeatureManager manager) {
        this.manager = manager;
    }

    @Value("${switch.feature.enabled}")
    private boolean switchEnabled;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        if (switchEnabled){
            name = "switch is enabled in properties file";
        }
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/toggle")
    public Greeting togglz(@RequestParam(value="name", defaultValue = "toggle_IT ") String name) {
        StringBuilder nameBuilder = new StringBuilder(name);
        for (Feature feature :manager.getFeatures()){
            if (manager.isActive(feature)){
                nameBuilder.append(feature.name()).append(" ");
            }
        }
        name = nameBuilder.toString();
        return new Greeting(101L, "toggle it: " + name);
    }

}
