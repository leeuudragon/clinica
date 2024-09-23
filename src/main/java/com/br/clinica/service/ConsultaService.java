package com.br.clinica.service;

import com.br.clinica.config.mapper.Mapper;
import com.br.clinica.dto.ConsultaDTO;
import com.br.clinica.model.Consulta;
import com.br.clinica.model.Medico;
import com.br.clinica.model.Paciente;
import com.br.clinica.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final Mapper mapper;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public ConsultaService(ConsultaRepository consultaRepository, Mapper mapper, PacienteService pacienteService, MedicoService medicoService) {
        this.consultaRepository = consultaRepository;
        this.mapper = mapper;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public ConsultaDTO salvar(ConsultaDTO request) {
        Consulta consulta = mapper.map(request, Consulta.class);

        Medico medico = medicoService.getEntidade(request.getMedico().getId());
        consulta.setMedico(medico);

        Paciente paciente = pacienteService.getEntidade(request.getPaciente().getId());
        consulta.setPaciente(paciente);

        Consulta consultaSalva = consultaRepository.save(consulta);
        return mapper.map(consultaSalva, ConsultaDTO.class);
    }

    public ConsultaDTO atualizar(ConsultaDTO request) {
        Consulta consulta = new Consulta();
        Optional<Consulta> opt = consultaRepository.findById(request.getId());
        if (opt.isPresent()) {
            consulta = opt.get();
        }
        Medico medico = medicoService.getEntidade(request.getMedico().getId());
        consulta.setMedico(medico);

        Paciente paciente = pacienteService.getEntidade(request.getPaciente().getId());
        consulta.setPaciente(paciente);

        consulta.setDataConsuta(request.getDataConsulta());

        Consulta consultaSalva = consultaRepository.save(consulta);
        return mapper.map(consultaSalva, ConsultaDTO.class);
    }

    public List<ConsultaDTO> listar() {
        List<Consulta> consulta = consultaRepository.findAll();
        return mapper.mapList(consulta, ConsultaDTO.class);
    }

    public void excluir(Integer id) {
        consultaRepository.deleteById(id);
    }

    public ConsultaDTO buscarPorId(Integer id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return mapper.map(consulta, ConsultaDTO.class);
    }
}
