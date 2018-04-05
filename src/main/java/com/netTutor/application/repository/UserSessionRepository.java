package com.netTutor.application.repository;

import com.netTutor.application.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends CrudRepository<UserLoggedSession, Long> {

    UserLoggedSession save(UserLoggedSession session);

    //UserLoggedSession findByUser(UserLoggedSession session);
  //  @Query("SELECT  uls FROM user_session WHERE uls.user_id = userId")
    UserLoggedSession findByUserId(Long userId);
}
