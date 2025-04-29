package com.bu.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EntityBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private LocalDateTime creation;

    public EntityBoard(Long id, String title, String writer, LocalDateTime creation) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.creation = creation;
    }

    public EntityBoard(String title, String writer, LocalDateTime creation) {
        this.title = title;
        this.writer = writer;
        this.creation = creation;
    }

    public EntityBoard(Long id) {
        this.id = id;
    }
}
