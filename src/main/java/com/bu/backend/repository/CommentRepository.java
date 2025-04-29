package com.bu.backend.repository;

import com.bu.backend.entity.EntityBoard;
import com.bu.backend.entity.EntityComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<EntityComment, Long> {
    List<EntityComment> findByBoardIdOrderByCreatedAtDesc(Long boardId);

    List<EntityComment> findByWriterOrderByCreatedAtDesc(String writer);
}
