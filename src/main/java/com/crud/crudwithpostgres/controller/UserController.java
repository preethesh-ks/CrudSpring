package com.crud.crudwithpostgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crud.crudwithpostgres.model.userDetails;
import com.crud.crudwithpostgres.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/adduser")
    public String addUser(@RequestBody userDetails user){
        userRepository.save(user);
        return "User added successfully";
    }

    @GetMapping("/users")
    public List<userDetails> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<userDetails> getUser(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, @RequestBody userDetails user){
        Optional<userDetails> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            userDetails updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setMobile(user.getMobile());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setCity(user.getCity());
            updatedUser.setState(user.getState());
            updatedUser.setCountry(user.getCountry());
            updatedUser.setPincode(user.getPincode());
            userRepository.save(updatedUser);
            return "User updated successfully";
        } else {
            return "User not found";
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}