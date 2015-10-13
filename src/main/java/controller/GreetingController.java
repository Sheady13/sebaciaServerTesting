package controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import model.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/test")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="number", defaultValue="Zero") String number) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, number));
    }
}