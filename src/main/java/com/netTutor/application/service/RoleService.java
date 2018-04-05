package com.netTutor.application.service;

import com.netTutor.application.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.netTutor.application.repository.*;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role addRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getRoleList() {
        return (List<Role>) roleRepository.findAll();
    }
}
