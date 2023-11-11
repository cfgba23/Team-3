package com.example.jpmorgan_mujeres2000api.repository;

import com.example.jpmorgan_mujeres2000api.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
