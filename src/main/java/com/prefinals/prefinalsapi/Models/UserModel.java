package com.prefinals.prefinalsapi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    public UserModel(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
