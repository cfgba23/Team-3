package com.example.jpmorgan_mujeres2000api.services.impl;

import com.example.jpmorgan_mujeres2000api.dto.ProposalDTO;
import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.exceptions.UserNotFoundException;
import com.example.jpmorgan_mujeres2000api.repository.ProposalRepository;
import com.example.jpmorgan_mujeres2000api.services.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    @Override
    public Proposal getByProposalId(Long proposalId) {
        if (proposalRepository.findById(proposalId).isEmpty()){
            throw new UserNotFoundException("Proposal not found");
        }
        return proposalRepository.findById(proposalId).get();
    }

    @Override
    public void createProposal(ProposalDTO proposal) {
        Proposal proposal1 = new Proposal();
        proposal1.setTitle(proposal.getTitle());
        proposal1.setType(proposal.getType());
        proposal1.setStartDate(proposal.getStartDate());
        proposal1.setEndDate(proposal.getEndDate());
        proposal1.setUserList(proposal.getUserList());
        proposalRepository.save(proposal1);
    }

    @Override
    public void updateProposal(Long proporsalId, ProposalDTO proposal) {
        Optional<Proposal> proposal1 = proposalRepository.findById(proporsalId);
        proposal1.get().setTitle(proposal.getTitle());
        proposal1.get().setType(proposal.getType());
        proposal1.get().setStartDate(proposal.getStartDate());
        proposal1.get().setEndDate(proposal.getEndDate());
        proposal1.get().setUserList(proposal.getUserList());
        proposalRepository.save(proposal1.get());
    }

    @Override
    public void deleteProposal(Long proposalId) {
        proposalRepository.deleteById(proposalId);
    }


    void validateExistingUser(Long id) {
        proposalRepository.findById(id).orElseThrow(() -> new RuntimeException("Proposal not found"));
    }
}
