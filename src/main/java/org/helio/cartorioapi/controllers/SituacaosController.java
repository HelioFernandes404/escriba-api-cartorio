package org.helio.cartorioapi.controllers;


import org.helio.cartorioapi.dto.SituacaosDTO;
import org.helio.cartorioapi.services.SituacaosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/situacaos")
public class SituacaosController {

    @Autowired
    private SituacaosServices service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SituacaosDTO> findById(@PathVariable String id) {
        SituacaosDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<SituacaosDTO> insert(@Valid @RequestBody SituacaosDTO dto) {
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
