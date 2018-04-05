package com.netTutor.application.service;

import com.netTutor.application.domain.*;
import com.netTutor.application.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService  extends BaseService{
    @Autowired
    UserRepository  userRepository;

    @Autowired
    UserLoggedSessionRepository userLoggedSessionRepository;

    @Autowired
    RoleRepository roleRepository;

//    @Autowired
//    StringUtils stringUtils;

    @Autowired
    UserSessionRepository userSessionRepository;
    public UserEntity addUser(UserEntity userEntity){

        userEntity =(UserEntity) generateInfo(userEntity);
        userEntity.setUsername(userEntity.getUsername().trim());
        userEntity.setFirstName(userEntity.getFirstName().trim());
        userEntity.setLastName(userEntity.getLastName().trim());
        userEntity.setAge(userEntity.getAge().trim());
        userEntity.setFullName(userEntity.getFullName().trim());

        long roleId = userEntity.getRole().getId();
        Role selectedRole= roleRepository.findOne(roleId);
        if(selectedRole!=null){
            userEntity.setRole(selectedRole);
            return userRepository.save(userEntity);
        }
        else {
                return null;
        }


    }

    public UserEntity authUser(UserEntity userEntity) {
        UserEntity loggedUser =  userRepository.findByUsername(userEntity.getUsername());
        if (loggedUser.getPassword().equals(userEntity.getPassword())){
            loggedUser.setAuthd(true);
            createUserSession(loggedUser);
            // Also Add User Dash Specific Data
            return loggedUser;
        }
        else{
            // Log failed  login with details
        }
        return loggedUser;
    }

    private boolean createUserSession(UserEntity user) {
        UserLoggedSession userLoggedSession = new UserLoggedSession();
        userLoggedSession.setUserId(user.getId());
        userLoggedSession.setStartTime(new Date().getTime());
        if (userSessionRepository.save(userLoggedSession)!=null){
            return true;
        }
        return false;
    }
    public boolean destroyUserSession(UserEntity user){
        UserLoggedSession session  = userLoggedSessionRepository.findByUserId(user.getId());
        if(session!=null){
            session.setEndTime(new Date().getTime());
            session.setDuration(session.getEndTime() - session.getStartTime());
            if(userSessionRepository.save(session)!=null){
                user.setAuthd(false);
                return true;
            }
        }

        return false;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        if (userList!=null){
            return userList;
        }
        return null;
    }

    public List<UserEntity> getAllUsersByRole(Long roleId) {
        List<UserEntity> userList = (List<UserEntity>) userRepository.findByRoleId(roleId);
        if (userList!=null){
            return userList;
        }
        return null;
    }
}
