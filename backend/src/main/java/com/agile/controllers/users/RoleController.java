package com.agile.controllers.users;

import com.agile.model.Role;
import com.agile.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "rest/roles")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @GetMapping(value = "rest/roles/{id}")
    public Role getRoleByID(@PathVariable(value = "id") Integer id) {
        return roleRepository.findOne(id);
    }
}
