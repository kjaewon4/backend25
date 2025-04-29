package com.bu.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class EntityComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private EntityBoard board;

    private String writer;  // 세션에서 가져오기
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
