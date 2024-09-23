package com.br.clinica.controller;

import com.br.clinica.dto.EspecialidadeDTO;
import com.br.clinica.service.EspecialidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/especialidade")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @RequestMapping(value = "/cadastrar")
    public ResponseEntity<EspecialidadeDTO> cadastraPaciente(@RequestBody EspecialidadeDTO request) {
        EspecialidadeDTO dto = especialidadeService.salvar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<EspecialidadeDTO> alterarPaciente(@RequestBody EspecialidadeDTO request) {
        EspecialidadeDTO dto = especialidadeService.atualizar(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<EspecialidadeDTO>> listarPaciente() {
        List<EspecialidadeDTO> dtos = especialidadeService.listar();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<EspecialidadeDTO> buscaPaciente(@PathVariable Integer id) {
        EspecialidadeDTO dto = especialidadeService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/excluir/{id}")
    public void excluirPaciente(@PathVariable Integer id) {
        especialidadeService.excluir(id);
    }
}
