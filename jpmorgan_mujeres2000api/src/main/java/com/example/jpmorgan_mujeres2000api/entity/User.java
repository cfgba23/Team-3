package com.example.jpmorgan_mujeres2000api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private Long userId;
    private String dni;
    private String name;
    private String surname;
    @ManyToMany(mappedBy = "userList")
    private List<Proposal> proposalList;
}
