package com.br.clinica.service;

import com.br.clinica.config.mapper.Mapper;
import com.br.clinica.dto.PacienteDTO;
import com.br.clinica.model.Paciente;
import com.br.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final Mapper mapper;

    public PacienteService(PacienteRepository pacienteRepository, Mapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    public PacienteDTO salvar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return mapper.map(pacienteSalvo, PacienteDTO.class);
    }

    public PacienteDTO atualizar(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteDTO.getId());
        if (pacienteOptional.isPresent()) {
            paciente = pacienteOptional.get();
        }
        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return mapper.map(pacienteSalvo, PacienteDTO.class);
    }

    public List<PacienteDTO> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return mapper.mapList(pacientes, PacienteDTO.class);
    }

    public void excluir(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO buscarPorId(Integer id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        return mapper.map(pacienteOptional, PacienteDTO.class);
    }

    public Paciente getEntidade(Integer id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        return pacienteOptional.orElse(null);
    }
}
