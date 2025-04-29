package com.bu.backend.repository;

import com.bu.backend.entity.EntityUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepoUser extends
        CrudRepository<EntityUser, Integer> {

    Optional<EntityUser> findByUseridAndUserpass(String userid, String userpass);
    Optional<EntityUser> findByUserid(String userid); // 회원가입 중복 체크용

//    @Query("SELECT u from EntityUser u WHERE u.userid = :userid AND u.userpass = :userpass")
//    public Optional<EntityUser> jpqlSelectUser(String userid, String userpass);
}
