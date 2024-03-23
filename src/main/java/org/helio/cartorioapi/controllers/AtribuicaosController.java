package org.helio.cartorioapi.controllers;

import org.helio.cartorioapi.dto.AtribuicaosDTO;
import org.helio.cartorioapi.services.AtribuicaosServices;
import org.helio.cartorioapi.services.SituacaosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/atribuicoes")
public class AtribuicaosController {


    @Autowired
    private AtribuicaosServices service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtribuicaosDTO> findById(@PathVariable String id) {
        AtribuicaosDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<AtribuicaosDTO> insert(@Valid @RequestBody AtribuicaosDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
