package org.example.schedule_managemant.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private String title;
    private String contents;
    private String name;
    private String password;
}
