package com.example.jpmorgan_mujeres2000api.services.impl;

import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.repository.ProposalRepository;
import com.example.jpmorgan_mujeres2000api.services.ProposalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    @Override
    public Proposal getByProposalId(Long proposalId) {
        return proposalRepository.findByProposalId(proposalId);
    }

    @Override
    public void createProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    @Override
    public void updateProposal(Long proporsalId, Proposal proposal) {
        Proposal proposal1 = proposalRepository.findByProposalId(proporsalId);
        proposal1.setTitle(proposal.getTitle());
        proposal1.setType(proposal.getType());
        proposal1.setStartDate(proposal.getStartDate());
        proposal1.setEndDate(proposal.getEndDate());
        proposalRepository.save(proposal1);
    }

    @Override
    public void deleteProposal(Long proposalId) {
        proposalRepository.deleteById(proposalId);
    }
}
