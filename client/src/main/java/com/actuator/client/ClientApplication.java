package com.actuator.client;

import com.actuator.client.greeting.domain.Greeting;
import com.actuator.client.greeting.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class ClientApplication {

    private final GreetingRepository greetingRepository;

    @PostConstruct
    public void addGreetings(){
        Greeting greeting = Greeting.builder()
                .id(1L)
                .contents("안녕~!")
                .createdTime(LocalDateTime.now())
                .build();
        greetingRepository.save(greeting);
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
