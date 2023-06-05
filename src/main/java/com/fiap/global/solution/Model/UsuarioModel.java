package com.fiap.global.solution.Model;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.*;


@Entity(name = "GS_USUARIO")
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
        @UniqueConstraint(name = "UK_CPF", columnNames = "cpf")
})
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false,unique = true, length = 100)
    @Email
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;



    @NotNull
    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoModel> endereco;

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

}
