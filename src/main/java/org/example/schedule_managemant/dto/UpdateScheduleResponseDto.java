package org.example.schedule_managemant.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponseDto {

    private final String title;
    private final String name;
    private final LocalDateTime modified;

    public UpdateScheduleResponseDto(String title, String name, LocalDateTime modified) {
        this.title = title;
        this.name = name;
        this.modified = modified;
    }
}
