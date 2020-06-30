package com.actuator.client.greeting.domain.dto.response;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public final class GreetingResponse {

    private final long id;
    private final String contents;

    private final LocalDateTime createdTime;

    private GreetingResponse(long id, String contents, LocalDateTime createdTime) {
        this.id = id;
        this.contents = contents;
        this.createdTime = createdTime;
    }

    public static GreetingResponse ok(long id, String contents, LocalDateTime createdTime) {
        return new GreetingResponse(id, contents, createdTime);
    }
}
