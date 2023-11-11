package com.example.jpmorgan_mujeres2000api.controller;



import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.entity.User;
import com.example.jpmorgan_mujeres2000api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    ResponseEntity<Object> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getByUserId(id), HttpStatus.OK);
    }
    @PostMapping("/user")
    ResponseEntity<Object> createUser(@RequestBody Object user){
        userService.createUser((User) user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    @DeleteMapping("/user/delete/{id}")
    ResponseEntity<Object> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
    @PostMapping("/user/add")
    ResponseEntity<Object> addProposal(@RequestBody Proposal proposal, @PathVariable List<Proposal> proposalList){
        userService.addProposal(proposal,proposalList);
        return new ResponseEntity<>("Proposal added", HttpStatus.OK);
    }
    @DeleteMapping("/user/delete")
    ResponseEntity<Object> deleteProposal(@RequestBody Proposal proposal,@PathVariable List<Proposal> proposalList){
        userService.deleteProposal(proposal,proposalList);
        return new ResponseEntity<>("Proposal removed",HttpStatus.OK);
    }

    @GetMapping("/user/add")
    ResponseEntity<Object> getProposal(@PathVariable List<Proposal> proposalList){
        return new ResponseEntity<>(userService.getProposal(proposalList),HttpStatus.OK);
    }
}
