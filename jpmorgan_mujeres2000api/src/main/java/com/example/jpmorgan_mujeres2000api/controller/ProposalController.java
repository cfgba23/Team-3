package com.example.jpmorgan_mujeres2000api.controller;

import com.example.jpmorgan_mujeres2000api.dto.ProposalDTO;
import com.example.jpmorgan_mujeres2000api.services.ProposalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
@Tag(name = "Proposal", description = "Api to manage proposals")
public class ProposalController {

    private final ProposalService proposalService;

    @Operation(summary = "Get all proposals")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Found the proposals"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Proposal not found")
    })
    @GetMapping("/proposal/{id}")
    ResponseEntity<Object> getProposal(@PathVariable Long id){
        return new ResponseEntity<>(proposalService.getByProposalId(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new proposal")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Proposal created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Proposal not found")
    })
    @PostMapping("/proposal")
    ResponseEntity<Object> createProposal(@RequestBody ProposalDTO proposal){
        proposalService.createProposal(proposal);
        return new ResponseEntity<>("Proposal created", HttpStatus.CREATED);
    }

    @Operation(summary = "Update a proposal")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Proposal updated"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Proposal not found")
    })
    @PutMapping("/proposal/update/{id}")
    ResponseEntity<Object> updateProposal(@PathVariable Long id, @RequestBody ProposalDTO proposal){
        proposalService.updateProposal(id, proposal);
        return new ResponseEntity<>("Proposal updated", HttpStatus.OK);
    }

    @Operation(summary = "Delete a proposal")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Proposal deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Proposal not found")
    })
    @DeleteMapping("/proposal/delete/{id}")
    ResponseEntity<Object> deleteProposal(@PathVariable Long id){
        proposalService.deleteProposal(id);
        return new ResponseEntity<>("Proposal deleted", HttpStatus.OK);
    }
}
