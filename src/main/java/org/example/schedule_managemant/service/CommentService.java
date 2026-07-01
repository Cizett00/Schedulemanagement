package org.example.schedule_managemant.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule_managemant.dto.*;
import org.example.schedule_managemant.entity.Comment;
import org.example.schedule_managemant.entity.Schedule;
import org.example.schedule_managemant.repository.CommentRepository;
import org.example.schedule_managemant.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateCommentResponseDto createComment(CreateCommentRequestDto requestDto, Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));

        List<Comment> commentList = commentRepository.findAll();
        if(commentList
                .stream()
                .filter(c -> c.getSchedule_id().equals(scheduleId))
                .count() >= 10){
            throw new IllegalStateException("댓글은 10개 까지 작성할 수 있습니다.");
        }

        Comment comment = new Comment(
                requestDto.getCm_content(),
                requestDto.getCm_name(),
                requestDto.getCm_password(),
                scheduleId
        );

        Comment saveComment = commentRepository.save(comment);

        return new CreateCommentResponseDto(
                saveComment.getCm_id(),
                saveComment.getCm_content(),
                saveComment.getCm_name(),
                saveComment.getCreatedAt(),
                saveComment.getModifiedAt()
        );
    }
}
