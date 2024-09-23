package com.br.clinica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

    private Integer id;
    private String nome;
    private EspecialidadeDTO especialidade;
    @JsonIgnoreProperties("medico")
    private List<ConsultaDTO> consultas;
}
