package com.example.springrest;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ApiController {

    UserService userService;

    ApiController() {
        userService = new UserService();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "<h1 style='font-family: Arial'>Welcome to Spring REST API</h1>";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<UserData> data() {
        return userService.getData();
    }

    @GetMapping(value = "/user/{id}")
    public @ResponseBody UserData getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public @ResponseBody UserData deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping(value = "/user/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody UserData addUser(@RequestBody UserData data) {
        return userService.addUser(data);
    }

    @PostMapping(value = "/user/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody ArrayList<UserData> updateUser(@RequestBody UserData data) {
        return userService.updateUser(data);
    }

}