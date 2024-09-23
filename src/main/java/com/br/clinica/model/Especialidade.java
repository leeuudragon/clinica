package com.br.clinica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "clinica", name = "Especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESPECIALIDADE")
    private Integer id;

    @Column(name = "NOME")
    private String nome;
}
