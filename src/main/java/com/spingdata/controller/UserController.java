package com.sapient.controller;


import com.sapient.entity.Movie;
import com.sapient.entity.Screen;
import com.sapient.entity.User;
import com.sapient.service.ScreenService;
import com.sapient.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{uuid}")
    ResponseEntity<User> read(@PathVariable("uuid") String uuid){
        User user=null;
        try
        {
            user=this.userService.get(UUID.fromString(uuid));
            return  new ResponseEntity<User>(user, null, HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity<User>(user,null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    User create(@RequestBody User user){
        user=this.userService.save(user);
        return  user;
    }

    @GetMapping
    @RequestMapping("/all")
    List<User> getAll(){
        return this.userService.getAll();
    }


    @PutMapping
    @RequestMapping("/")
    User update(User user){
        user=this.userService.update(user);
        return  user;
    }

}

