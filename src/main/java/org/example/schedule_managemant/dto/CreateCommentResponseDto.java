package org.example.schedule_managemant.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCommentResponseDto {

    private final Long cm_id;
    private final String cm_content;
    private final String cm_name;
    private final LocalDateTime cm_created;
    private final LocalDateTime cm_modified;

    public CreateCommentResponseDto(Long cm_id, String cm_content, String cm_name, LocalDateTime cm_created, LocalDateTime cm_modified) {
        this.cm_id = cm_id;
        this.cm_content = cm_content;
        this.cm_name = cm_name;
        this.cm_created = cm_created;
        this.cm_modified = cm_modified;
    }
}
