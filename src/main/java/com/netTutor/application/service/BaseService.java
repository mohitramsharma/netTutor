package com.netTutor.application.service;

import com.netTutor.application.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BaseService {

    public BaseEntity generateInfo(BaseEntity entity){
        if (entity!=null && entity.getCreationDate()==null){
            // Generate Creation Date
            entity.setCreationDate(new Date().getTime());
        }

        if (entity!=null){
            // Generate Modification Date
            entity.setModificationDate(new Date().getTime());
        }
        return entity;
    }
}
