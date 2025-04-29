package com.bu.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String userid;

    @Column(unique = true, nullable = false)
    private String usernickname;

    @Column(unique = true, nullable = false)
    private String username;  // 실명

    @Column(nullable = false)
    String userpass;

    @Column(nullable = false)
    private LocalDateTime creation = LocalDateTime.now();

    public EntityUser(String userid, String userpass) {
        this.userid = userid;
        this.userpass = userpass;
    }

    public EntityUser(String userid, String usernickname, String username, String userpass) {
        this.userid = userid;
        this.usernickname = usernickname;
        this.username = username;
        this.userpass = userpass;
    }
}
