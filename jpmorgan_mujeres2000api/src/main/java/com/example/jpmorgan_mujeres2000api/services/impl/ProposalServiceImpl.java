package com.example.jpmorgan_mujeres2000api.services.impl;

import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.repository.ProposalRepository;
import com.example.jpmorgan_mujeres2000api.services.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    @Override
    public Proposal getByProposalId(Long proposalId) {
        return proposalRepository.findById(proposalId).get();
    }

    @Override
    public void createProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    @Override
    public void updateProposal(Long proporsalId, Proposal proposal) {
        Optional<Proposal> proposal1 = proposalRepository.findById(proporsalId);
        proposal1.get().setTitle(proposal.getTitle());
        proposal1.get().setType(proposal.getType());
        proposal1.get().setStartDate(proposal.getStartDate());
        proposal1.get().setEndDate(proposal.getEndDate());
        proposal1.get().setUserList(proposal.getUserList());
    }

    @Override
    public void deleteProposal(Long proposalId) {
        proposalRepository.deleteById(proposalId);
    }
}
