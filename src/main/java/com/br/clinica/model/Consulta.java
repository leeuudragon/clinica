package com.br.clinica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(schema = "CLINICA", name = "TB_CONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MEDICO_CONSULTA")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_CONSULTA")
    private Paciente paciente;

    @Column(name = "DATA_CONSULTA")
    private Date dataConsuta;
}
