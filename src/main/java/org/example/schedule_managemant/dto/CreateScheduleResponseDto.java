package org.example.schedule_managemant.dto;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final String name;
    private final LocalDateTime created;
    private final LocalDateTime modified;

    public CreateScheduleResponseDto(Long id, String title, String contents, String name, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }
}
