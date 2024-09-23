package com.br.clinica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeDTO {

    private Integer id;
    private String nome;
    @JsonIgnoreProperties("especialidade")
    private List<MedicoDTO> medicos;
}
