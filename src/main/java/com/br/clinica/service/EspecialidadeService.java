package com.br.clinica.service;

import com.br.clinica.config.mapper.Mapper;
import com.br.clinica.dto.EspecialidadeDTO;
import com.br.clinica.model.Especialidade;
import com.br.clinica.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;
    private final Mapper mapper;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository, Mapper mapper) {
        this.especialidadeRepository = especialidadeRepository;
        this.mapper = mapper;
    }

    public EspecialidadeDTO salvar(EspecialidadeDTO request) {
        Especialidade especialidade = mapper.map(request, Especialidade.class);

        Especialidade especialidadeSalvo = especialidadeRepository.save(especialidade);

        return mapper.map(especialidadeSalvo, EspecialidadeDTO.class);
    }

    public EspecialidadeDTO atualizar(EspecialidadeDTO request) {
        Especialidade especialidade = mapper.map(request, Especialidade.class);
        return mapper.map(especialidadeRepository.save(especialidade), EspecialidadeDTO.class);
    }

    public List<EspecialidadeDTO> listar() {
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        return mapper.mapList(especialidades, EspecialidadeDTO.class);
    }

    public void excluir(Integer id) {
        especialidadeRepository.deleteById(id);
    }

    public EspecialidadeDTO buscarPorId(Integer id) {
        Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
        return mapper.map(especialidade, EspecialidadeDTO.class);
    }

    public Optional<Especialidade> getEntity(Integer id) {
        return especialidadeRepository.findById(id);
    }
}
