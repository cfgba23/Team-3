package com.example.jpmorgan_mujeres2000api.dto;

import com.example.jpmorgan_mujeres2000api.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposalDTO {
    @JsonAlias("proposal_id")
    private Long proposalId;
    @JsonAlias("title")
    private String title;
    @JsonAlias("type")
    private String type;
    @JsonAlias("start_date")
    private LocalDate startDate;
    @JsonAlias("end_date")
    private LocalDate endDate;
    @ManyToMany
    @JsonAlias("user_list")
    private List<User> userList;
}