package com.br.clinica.repository;

import com.br.clinica.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}
