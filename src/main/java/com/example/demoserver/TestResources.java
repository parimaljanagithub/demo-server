package com.example.demoserver;

import com.example.demoserver.model.ResponseMessage;
import com.example.demoserver.model.User;
import com.example.demoserver.model.UserLogin;
import com.example.demoserver.storage.StoreInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestResources {

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity RegisterUser(@RequestBody User user) {
        System.out.println("user details"+ user);
        StoreInformation.addUserInfo(user);
        System.out.println("User created successfully");

        ResponseEntity re = new ResponseEntity(new ResponseMessage("registartion successfull"),HttpStatus.CREATED);
        System.out.println(re);
        return re;
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        User u = StoreInformation.userInfo.get(id);
        ResponseEntity re = new ResponseEntity(u,HttpStatus.OK);
        return re;
    }

    @PostMapping(path = "/login" , consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody UserLogin userLogin){
        User u = StoreInformation.userInfo.get(userLogin.getUserId());
        ResponseEntity re;
        if(u !=null && u.getPassword().equals(userLogin.getPassword())) {
            System.out.println("login successfull");
            re = new ResponseEntity(new ResponseMessage("login successfull"),HttpStatus.OK);
        } else {
            System.out.println("login failed");
            re = new ResponseEntity(new ResponseMessage("login failed"), HttpStatus.UNAUTHORIZED);
        }

        return re;
    }

    @GetMapping(path = "/BookStore/v1/Books",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getListOfAvailableBooks() {

    }

}
