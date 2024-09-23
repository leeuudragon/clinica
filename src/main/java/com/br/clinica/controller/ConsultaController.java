package com.br.clinica.controller;

import com.br.clinica.dto.ConsultaDTO;
import com.br.clinica.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ConsultaDTO> cadastrar(@RequestBody ConsultaDTO request) {
        ConsultaDTO dto = consultaService.salvar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<ConsultaDTO> alterar(@RequestBody ConsultaDTO request) {
        ConsultaDTO dto = consultaService.atualizar(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ConsultaDTO>> listar() {
        List<ConsultaDTO> lista = consultaService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<ConsultaDTO> buscar(@PathVariable Integer id) {
        ConsultaDTO dto = consultaService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/excluir/{id}")
    public void excluir(@PathVariable Integer id) {
        consultaService.excluir(id);
    }
}
