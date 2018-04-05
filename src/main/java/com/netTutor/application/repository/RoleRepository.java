package com.netTutor.application.repository;

import com.netTutor.application.domain.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role save(Role role);

    UserEntity findByUser(UserEntity user);

}
