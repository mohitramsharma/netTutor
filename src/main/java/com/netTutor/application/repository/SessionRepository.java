package com.netTutor.application.repository;

import com.netTutor.application.domain.Session;
import com.netTutor.application.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

    Session save(Session session);

    Session findByName(String username);

    @Query("")
    List<Session> findByUsers(Long userId);

}
