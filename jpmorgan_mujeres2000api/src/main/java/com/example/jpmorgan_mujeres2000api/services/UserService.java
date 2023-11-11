package com.example.jpmorgan_mujeres2000api.services;


import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.entity.User;

import java.util.List;

public interface UserService {
    User getByUserId(Long userId);
    void createUser(User user);
    void deleteUser(Long userId);

    void addProposal(Proposal proposal, List<Proposal> proposalList);
    void deleteProposal(Proposal proposal, List<Proposal> proposalList);
    List<Proposal> getProposal(List<Proposal> proposalList);
}
