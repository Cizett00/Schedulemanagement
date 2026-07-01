package org.example.schedule_managemant.repository;

import org.example.schedule_managemant.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
