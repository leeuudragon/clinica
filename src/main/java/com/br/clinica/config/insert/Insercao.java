package com.br.clinica.config.insert;

import com.br.clinica.model.Consulta;
import com.br.clinica.model.Especialidade;
import com.br.clinica.model.Medico;
import com.br.clinica.model.Paciente;
import com.br.clinica.repository.ConsultaRepository;
import com.br.clinica.repository.EspecialidadeRepository;
import com.br.clinica.repository.MedicoRepository;
import com.br.clinica.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Insercao implements CommandLineRunner {

    private final EspecialidadeRepository especialidadeRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    private final ConsultaRepository consultaRepository;

    public Insercao(EspecialidadeRepository especialidadeRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository, ConsultaRepository consultaRepository) {
        this.especialidadeRepository = especialidadeRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Inserindo especialidades
        Especialidade cardiologia = new Especialidade();
        cardiologia.setNome("Cardiologia");
        especialidadeRepository.save(cardiologia);

        Especialidade dermatologia = new Especialidade();
        dermatologia.setNome("Dermatologia");
        especialidadeRepository.save(dermatologia);

        Especialidade ortopedia = new Especialidade();
        ortopedia.setNome("Ortopedia");
        especialidadeRepository.save(ortopedia);

        // Inserindo médicos
        Medico drJoao = new Medico();
        drJoao.setNome("Dr. João");
        drJoao.setEspecialidade(cardiologia);
        medicoRepository.save(drJoao);

        Medico drMaria = new Medico();
        drMaria.setNome("Dr. Maria");
        drMaria.setEspecialidade(dermatologia);
        medicoRepository.save(drMaria);

        Medico drAugusto = new Medico();
        drAugusto.setNome("Dr. Augusto");
        drAugusto.setEspecialidade(ortopedia);
        medicoRepository.save(drAugusto);

        // Inserindo pacientes
        Paciente carlos = new Paciente();
        carlos.setNome("Carlos Silva");
        carlos.setCpf("12345678901");
        pacienteRepository.save(carlos);

        Paciente ana = new Paciente();
        ana.setNome("Ana Souza");
        ana.setCpf("09876543210");
        pacienteRepository.save(ana);

        // Inserindo consultas
        Consulta consulta = new Consulta();
        consulta.setMedico(drJoao);
        consulta.setPaciente(carlos);
        consulta.setDataConsuta(new java.sql.Date(System.currentTimeMillis()));
        consultaRepository.save(consulta);
    }
}
