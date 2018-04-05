package com.netTutor.application.repository;

import com.netTutor.application.domain.UserLoggedSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoggedSessionRepository extends CrudRepository<UserLoggedSession, Long> {

    UserLoggedSession save(UserLoggedSession session);

    //UserLoggedSession findByUser(UserLoggedSession session);
   // @Query("SELECT  uls FROM user_session WHERE uls.user_id = userId")
    UserLoggedSession findByUserId(Long userId);
}
