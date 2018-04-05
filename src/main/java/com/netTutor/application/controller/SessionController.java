package com.netTutor.application.controller;

import com.netTutor.application.domain.Session;
import com.netTutor.application.domain.UserEntity;
import com.netTutor.application.service.SessionService;
import com.netTutor.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "user/{userId}/add",method =RequestMethod.POST )
    ResponseEntity<?> addSession(@RequestBody Session session,@PathVariable long userId){

        Session createdSession = sessionService.addSession(session,userId);
        if(createdSession!=null){
            return new ResponseEntity<>(createdSession, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/",method =RequestMethod.GET )
    ResponseEntity<?> getSessions(){
        List<Session> sessions = sessionService.getSessions();
        if (sessions!=null){
            return new ResponseEntity<>(sessions,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/user/{userId}",method =RequestMethod.GET )
    ResponseEntity<?> getSessionsByUser(@PathVariable Long userId){
        List<Session> sessions = sessionService.getSessionsByUser(userId);
        if (sessions!=null){
            return new ResponseEntity<>(sessions,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/{sessionId}/user/{userId}",method =RequestMethod.POST )
    ResponseEntity<?> joinSessionsById(@PathVariable Long  sessionId,@PathVariable Long userId){
        Session session = sessionService.getSessionsBySessionId(userId,sessionId);
        if (session!=null){
            return new ResponseEntity<>(session,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

}
