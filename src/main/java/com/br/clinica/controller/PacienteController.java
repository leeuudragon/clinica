package com.br.clinica.controller;

import com.br.clinica.dto.PacienteDTO;
import com.br.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @RequestMapping(value = "/cadastrar")
    public ResponseEntity<PacienteDTO> cadastraPaciente(@RequestBody PacienteDTO request) {
        PacienteDTO dto = pacienteService.salvar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<PacienteDTO> alterarPaciente(@RequestBody PacienteDTO request) {
        PacienteDTO dto = pacienteService.atualizar(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<PacienteDTO>> listarPaciente() {
        List<PacienteDTO> dtos = pacienteService.listar();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<PacienteDTO> buscaPaciente(@PathVariable Integer id) {
        PacienteDTO dto = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/excluir/{id}")
    public void excluirPaciente(@PathVariable Integer id) {
        pacienteService.excluir(id);
    }
}
