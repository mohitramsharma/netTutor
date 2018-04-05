package com.netTutor.application.controller;

import com.netTutor.application.domain.*;
import com.netTutor.application.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/add",method =RequestMethod.POST )
    Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }


    @RequestMapping(method =RequestMethod.GET )
    List<Role> getRoleList(){
        return roleService.getRoleList();
    }
}
