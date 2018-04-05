package com.netTutor.application.controller;

import com.netTutor.application.domain.*;
import com.netTutor.application.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add",method =RequestMethod.POST )
    ResponseEntity<?> addUser(@RequestBody UserEntity userEntity){

        UserEntity createdUser = userService.addUser(userEntity);
        if(createdUser!=null){
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/",method =RequestMethod.GET )
    ResponseEntity<?> getUsers(){
        List<UserEntity> userEntities = userService.getAllUsers();
        if (userEntities!=null){
            return new ResponseEntity<>(userEntities,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/role/{roleId}",method =RequestMethod.GET )
    ResponseEntity<?> getUsersByRole(@PathVariable Long roleId){
        List<UserEntity> userEntities = userService.getAllUsersByRole(roleId);
        if (userEntities!=null){
            return new ResponseEntity<>(userEntities,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

}
