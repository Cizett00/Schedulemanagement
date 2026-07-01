package org.example.schedule_managemant.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule_managemant.dto.CreateCommentRequestDto;
import org.example.schedule_managemant.dto.CreateCommentResponseDto;
import org.example.schedule_managemant.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comments/{schedule_id}")
    public ResponseEntity<CreateCommentResponseDto> CreateComment(
            @PathVariable Long schedule_id,
            @RequestBody CreateCommentRequestDto requestDto
            ){
        CreateCommentResponseDto result =  commentService.createComment(requestDto, schedule_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
