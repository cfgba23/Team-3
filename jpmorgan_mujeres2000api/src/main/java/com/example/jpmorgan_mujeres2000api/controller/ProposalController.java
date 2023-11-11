package com.example.jpmorgan_mujeres2000api.controller;

import com.example.jpmorgan_mujeres2000api.dto.ProposalDTO;
import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.services.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class ProposalController {

    private final ProposalService proposalService;

    @GetMapping("/proposal/{id}")
    ResponseEntity<Object> getProposal(@PathVariable Long id){
        return new ResponseEntity<>(proposalService.getByProposalId(id), HttpStatus.OK);
    }

    @PostMapping("/proposal")
    ResponseEntity<Object> createProposal(@RequestBody ProposalDTO proposal){
        proposalService.createProposal(proposal);
        return new ResponseEntity<>("Proposal created", HttpStatus.CREATED);
    }

    @PutMapping("/proposal/update/{id}")
    ResponseEntity<Object> updateProposal(@PathVariable Long id, @RequestBody ProposalDTO proposal){
        proposalService.updateProposal(id, proposal);
        return new ResponseEntity<>("Proposal updated", HttpStatus.OK);
    }

    @DeleteMapping("/proposal/delete/{id}")
    ResponseEntity<Object> deleteProposal(@PathVariable Long id){
        proposalService.deleteProposal(id);
        return new ResponseEntity<>("Proposal deleted", HttpStatus.OK);
    }
}
