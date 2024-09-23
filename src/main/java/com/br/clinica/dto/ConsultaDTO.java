package com.br.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    private Integer id;
    private MedicoDTO medico;
    private PacienteDTO paciente;
    private Date dataConsulta;
}
