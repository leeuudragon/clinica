package com.br.clinica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(schema = "CLINICA", name = "TB_PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PACIENTE")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Consulta> consultas;
}
