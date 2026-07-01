package org.example.schedule_managemant.dto;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {
    private String cm_content;
    private String cm_name;
    private String cm_password;
}
