package com.fiap.global.solution.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "GS_ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String nome;

}
