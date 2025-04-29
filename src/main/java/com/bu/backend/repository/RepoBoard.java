package com.bu.backend.repository;

import com.bu.backend.entity.EntityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoBoard extends JpaRepository<EntityBoard, Long> {

    List<EntityBoard> findByWriterOrderByCreationDesc(String writer);

}
