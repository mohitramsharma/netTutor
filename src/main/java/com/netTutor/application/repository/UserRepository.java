package com.netTutor.application.repository;

import com.netTutor.application.domain.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity save(UserEntity userEntity);

    UserEntity findByUsername(String username);

    List<UserEntity> findByRoleId(Long roleId);

}
