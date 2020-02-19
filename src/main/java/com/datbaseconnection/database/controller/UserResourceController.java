package com.datbaseconnection.database.controller;

import com.datbaseconnection.database.model.Users;
import com.datbaseconnection.database.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResourceController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll()
    {
        return userRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Users> persist(@RequestBody final Users users)
    {
        userRepository.save(users);
        return userRepository.findAll();
    }
}
