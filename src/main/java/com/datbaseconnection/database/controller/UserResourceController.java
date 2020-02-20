package com.datbaseconnection.database.controller;

import com.datbaseconnection.database.model.Users;
import com.datbaseconnection.database.service.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResourceController {
    @Autowired
    UserRepository userRepository;

    //Find all Users
    @GetMapping(value = "/all")
    public List<Users> getAll()
    {
        return userRepository.findAll();
    }

    //Create a User
    @PostMapping(value = "/load")
    public List<Users> persist(@RequestBody final Users users)
    {
        userRepository.save(users);
        return userRepository.findAll();
    }

    //find a single user by id
    @GetMapping(value = "/byid/{id}")
    public Users findByFirstName(@PathVariable int id)
    {
        return userRepository.findById(id).get();
    }

    //Update a User Data
    @PutMapping(value = "/update/{id}")
    Users updateUser(@RequestBody final Users users,@PathVariable int id)
    {
         return userRepository.findById(id).map(users1 -> {users1.setFirst_name((users.getFirst_name()));
         users1.setLast_name(users.getLast_name());
         users1.setContact_id(users.getContact_id());
         return userRepository.save(users1);}).orElseGet(()->{users.setContact_id(id);
         return userRepository.save(users);});
    }

    //
    @DeleteMapping(value = "/delete/{id}")
   void deleteUser(@PathVariable int id)
   {
       userRepository.deleteById(id);
   }

}
