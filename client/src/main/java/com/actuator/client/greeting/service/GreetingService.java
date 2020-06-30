package com.actuator.client.greeting.service;

import com.actuator.client.greeting.domain.Greeting;
import com.actuator.client.greeting.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public Greeting findById(long id) {
        return greetingRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }
}
