package com.example.jpmorgan_mujeres2000api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "proposal")
public class Proposal {
    @Id
    private Long proposalId;
    private String title;
    private String type;
    @ManyToMany(mappedBy = "proposalList")
    private List<User> userList;
    private LocalDate startDate;
    private LocalDate endDate;
}
