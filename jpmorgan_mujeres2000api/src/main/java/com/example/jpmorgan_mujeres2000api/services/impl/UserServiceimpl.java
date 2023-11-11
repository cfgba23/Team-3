package com.example.jpmorgan_mujeres2000api.services.impl;




import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import com.example.jpmorgan_mujeres2000api.entity.User;
import com.example.jpmorgan_mujeres2000api.exceptions.UserNotFoundException;
import com.example.jpmorgan_mujeres2000api.repository.UserRepository;
import com.example.jpmorgan_mujeres2000api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Long userId) {
        if (userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return userRepository.findById(userId).get();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }


    @Override
    public void addProposal(Proposal proposal, List<Proposal> proposalList) {
        proposalList.add(proposal);
    }

    @Override
    public void deleteProposal(Proposal proposal, List<Proposal> proposalList) {
        proposalList.remove(proposal);
    }

    @Override
    public List<Proposal> getProposal(List<Proposal> proposalList) {
        return proposalList;
    }



}
