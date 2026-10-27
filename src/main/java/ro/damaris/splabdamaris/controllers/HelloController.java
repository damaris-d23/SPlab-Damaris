package ro.damaris.splabdamaris.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.damaris.splabdamaris.difexamples.ClientComponent;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {

    private final ClientComponent clientComponent;

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot<br>Hello from ClientComponent = " + clientComponent.toString();
    }
}