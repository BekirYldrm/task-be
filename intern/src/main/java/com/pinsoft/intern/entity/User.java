package com.pinsoft.intern.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    private Long id;

    private String name;
    private String lastname;
    private String email;
    private String password;
    private float balance;


    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Action> actions;
}
