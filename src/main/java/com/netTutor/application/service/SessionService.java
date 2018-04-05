package com.netTutor.application.service;

import com.netTutor.application.domain.Role;
import com.netTutor.application.domain.Session;
import com.netTutor.application.domain.UserEntity;
import com.netTutor.application.domain.UserLoggedSession;
import com.netTutor.application.repository.*;
import com.opentok.ArchiveMode;
import com.opentok.MediaMode;
import com.opentok.OpenTok;
import com.opentok.SessionProperties;
import com.opentok.exception.OpenTokException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionService extends BaseService{
    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserLoggedSessionRepository userLoggedSessionRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    StringUtils stringUtils;

    @Autowired
    UserSessionRepository userSessionRepository;


    public Session addSession(Session session, long userId){
        Session createdSession = (Session) generateInfo(session);
        UserEntity sessionUser = userRepository.findOne(userId);

        if(sessionUser!=null){
            createdSession.setUsers(Arrays.asList(sessionUser));
            createdSession = generateOTSession(createdSession,true);
            System.out.println("SessionId: "+createdSession.getSessionId()+"\n Token:"+createdSession.getToken());
        }
        if (createdSession!=null){
            createdSession = sessionRepository.save(createdSession);
            return createdSession;
        }

        return null;
    }

    private Session generateOTSession(Session session,boolean onlyToken) {
        // A session that attempts to stream media directly between clients:
        try {
            int apiKey = 46056512; // YOUR API KEY
            String apiSecret = "1c7a7a3c42c0adb454fe2029eff94ec1e947a0d2";
            OpenTok opentok = new OpenTok(apiKey, apiSecret);
            // A Session with a location hint:
            com.opentok.Session otSession = opentok.createSession();

            String sessionId = "2_MX40NjA1NjUxMn5-MTUyMjc4OTY1NDQ2Nn42QUVla05OT2EwN0t2dXlDMlBzU1p0VU1-UH4";
            String token = opentok.generateToken(sessionId);

            session.setSessionId(sessionId);
            session.setToken(token);

        } catch (OpenTokException e) {
            e.printStackTrace();
        }

        return session;

    }

    public List<Session> getSessions() {
        List<Session> sessions = (List<Session>) sessionRepository.findAll();
        if (sessions!=null){
            return sessions;
        }
        return null;
    }

    public List<Session> getSessionsByUser(Long userId) {
        List<Session> sessions = (List<Session>) sessionRepository.findByUsers(userId);
        if (sessions!=null){
            return sessions;
        }
        return null;
    }


    public Session getSessionsBySessionId(Long userId, Long sessionId) {
        Session currentSession = sessionRepository.findOne(sessionId);
        if (currentSession!=null){
            currentSession = generateOTSession(currentSession,true);
            if (currentSession.getToken()!=null && !currentSession.getToken().isEmpty()){
                return currentSession;
            }
        }
        return currentSession;
    }
}
