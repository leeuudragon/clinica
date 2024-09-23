package com.br.clinica.controller;

import com.br.clinica.dto.MedicoDTO;
import com.br.clinica.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<MedicoDTO> cadastrarMedico(@RequestBody MedicoDTO request) {
        MedicoDTO dto = medicoService.salvar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<MedicoDTO> alterarMedico(@RequestBody MedicoDTO request) {
        MedicoDTO dto = medicoService.atualizar(request);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<MedicoDTO>> listarMedico() {
        return ResponseEntity.ok(medicoService.listar());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<MedicoDTO> buscarMedico(@PathVariable Integer id) {
        MedicoDTO dto = medicoService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/excluir/{id}")
    public void excluirMedico(@PathVariable Integer id) {
        medicoService.remover(id);
    }
}
