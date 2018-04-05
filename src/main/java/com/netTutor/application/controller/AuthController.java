package com.netTutor.application.controller;

import com.netTutor.application.domain.*;
import com.netTutor.application.domain.enums.Role_Enum;
import com.netTutor.application.service.*;
import com.netTutor.application.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method =RequestMethod.POST )
    RespEn authUser(@RequestBody UserEntity userEntity){
        UserEntity loggedUser =userService.authUser(userEntity);
        if (loggedUser!=null){
                return new RespEn(loggedUser, "Message Success",HttpStatus.OK, true);
        }
        return new RespEn(loggedUser,"Message faliure",HttpStatus.UNAUTHORIZED,false);
    }

    @RequestMapping(value = "/logout",method =RequestMethod.POST )
    ResponseEntity<Boolean> inAuthUser(@RequestBody UserEntity userEntity){
        UserEntity loggedUser =userService.findByUsername(userEntity.getUsername());
        if (userService.destroyUserSession(loggedUser)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.UNAUTHORIZED);
    }


}
