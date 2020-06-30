package com.actuator.client.greeting.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "greeting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "greetingIdGen")
    @SequenceGenerator(name = "greetingIdGen", sequenceName = "GREETING_ID_SEQ", allocationSize = 20)
    private long id;

    private String contents;

    private LocalDateTime createdTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return id == greeting.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
