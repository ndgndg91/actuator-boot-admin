package com.actuator.client.greeting.controller;

import com.actuator.client.greeting.domain.Greeting;
import com.actuator.client.greeting.domain.dto.response.GreetingResponse;
import com.actuator.client.greeting.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/{id}")
    public ResponseEntity<GreetingResponse> byId(@PathVariable long id) {
        Greeting greeting = greetingService.findById(id);
        return ResponseEntity.ok(
                GreetingResponse.ok(
                        greeting.getId(),
                        greeting.getContents(),
                        greeting.getCreatedTime()
                )
        );
    }
}
