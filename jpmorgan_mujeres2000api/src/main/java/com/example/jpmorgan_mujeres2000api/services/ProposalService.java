package com.example.jpmorgan_mujeres2000api.services;

import com.example.jpmorgan_mujeres2000api.entity.Proposal;

public interface ProposalService {
    Proposal getByProposalId(Long proposalId);
    void createProposal(Proposal proposal);
    void updateProposal(Long proposalId, Proposal proposal);
    void deleteProposal(Long proposalId);


}
