package com.br.clinica.service;

import com.br.clinica.config.mapper.Mapper;
import com.br.clinica.dto.MedicoDTO;
import com.br.clinica.model.Especialidade;
import com.br.clinica.model.Medico;
import com.br.clinica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final Mapper mapper;
    private final EspecialidadeService especialidadeService;

    public MedicoService(MedicoRepository medicoRepository, Mapper mapper, EspecialidadeService especialidadeService) {
        this.medicoRepository = medicoRepository;
        this.mapper = mapper;
        this.especialidadeService = especialidadeService;
    }

    public MedicoDTO salvar(MedicoDTO request) {
        Medico medico = mapper.map(request, Medico.class);

        Medico medicoSalvo = medicoRepository.save(medico);

        return mapper.map(medicoSalvo, MedicoDTO.class);
    }

    public MedicoDTO atualizar(MedicoDTO request) {
        Medico medico = new Medico();

        Optional<Medico> opt = medicoRepository.findById(request.getId());

        if (opt.isPresent()) {
            medico = opt.get();
        }

        Optional<Especialidade> optionalEspecialidade = especialidadeService.getEntity(request.getEspecialidade().getId());

        if (optionalEspecialidade.isPresent()) {
            medico.setEspecialidade(optionalEspecialidade.get());
        }

        medico.setNome(request.getNome());

        medico = medicoRepository.save(medico);

        return mapper.map(medico, MedicoDTO.class);
    }

    public void remover(Integer id) {
        medicoRepository.deleteById(id);
    }

    public List<MedicoDTO> listar() {
        List<Medico> medicos = medicoRepository.findAll();
        return mapper.mapList(medicos, MedicoDTO.class);
    }

    public MedicoDTO buscarPorId(Integer id) {
        Optional<Medico> opt = medicoRepository.findById(id);
        return opt.map(medico -> mapper.map(medico, MedicoDTO.class)).orElse(null);
    }

    public Medico getEntidade(Integer id) {
        Optional<Medico> opt = medicoRepository.findById(id);
        return opt.orElse(null);
    }
}
