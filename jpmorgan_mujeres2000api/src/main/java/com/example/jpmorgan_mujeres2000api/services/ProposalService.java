package com.example.jpmorgan_mujeres2000api.services;

import com.example.jpmorgan_mujeres2000api.dto.ProposalDTO;
import com.example.jpmorgan_mujeres2000api.entity.Proposal;

public interface ProposalService {
    Proposal getByProposalId(Long proposalId);
    void createProposal(ProposalDTO proposal);
    void updateProposal(Long id, ProposalDTO proposal);
    void deleteProposal(Long proposalId);

}
