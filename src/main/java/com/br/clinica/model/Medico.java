package com.br.clinica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(schema = "CLINICA", name = "TB_MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICO")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIALIDADE")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Consulta> consultas;
}
