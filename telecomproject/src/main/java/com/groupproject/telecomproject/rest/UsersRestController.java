package com.groupproject.telecomproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupproject.telecomproject.entity.Users;
import com.groupproject.telecomproject.service.UsersService;


@RestController
@RequestMapping("/api")
public class UsersRestController {

    private UsersService usersService;

    @Autowired
    public UsersRestController(UsersService theUsersService) {
        usersService = theUsersService;
    }

    //expose "/users" and return list of users
    @GetMapping("/users")
    public List<Users> findAll() {
        return usersService.findAll();
    }

    // add mapping for GET /users/{user_id}
    @GetMapping("/users/{user_id}")
    public Users getUsers(@PathVariable int user_id) {
        Users user = usersService.findById(user_id);
    //throw exception if user_id not found
        if (user == null){
            throw new RuntimeException("user_id Not Found" + user_id);
        }

        return user;
    }

    // add mapping for POST /users - add new user
    @PostMapping("/users")
    public Users addUser (@RequestBody Users user){
        //also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item...instead of update

        user.setUser_id(0);

        usersService.save(user);
        return user;
    }

    // add mapping for PUT /users - update existing user
    @PutMapping("/users")
    public Users updateUser ( @RequestBody Users user){
        usersService.save(user);
        return user;
    }

    // add mapping for DELETE /users/{user_id} - delete user
    @DeleteMapping("/users/{user_id}")
    public String deleteUser (@PathVariable int user_id){
        Users tempUser = usersService.findById(user_id);
    // throw exception if user_id not found
    if (tempUser == null){
        throw new RuntimeException("user_id Not Found" + user_id);
    }

    usersService.deleteById(user_id);
    return "Deleted user with id: " + user_id;
    }
}
