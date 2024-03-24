package org.helio.cartorioapi.controllers;

import org.helio.cartorioapi.dto.CartoriosDTO;
import org.helio.cartorioapi.dto.CartoriosMinDTO;
import org.helio.cartorioapi.dto.SituacaosMinDTO;
import org.helio.cartorioapi.entidades.CartorioComAtribuicoes;
import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.helio.cartorioapi.services.CartoriosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartorios")
public class CartoriosController {

    @Autowired
    private CartoriosRepository  cartoriosRepository;

    @Autowired
    private CartoriosServices service;

    @GetMapping
    public ResponseEntity<Page<CartoriosMinDTO>> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").ascending());
        Page<CartoriosMinDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartorios> getCartorioById(@PathVariable Integer id) {
        Cartorios cartorio = service.getbyId(id);
        if (cartorio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartorio);
    }

    @GetMapping("/get/v1")
    public List<CartorioComAtribuicoes> getCartoriosComAtribuicoes() {
        List<Object[]> results = cartoriosRepository.findCartoriosWithAtribuicoes();
        List<CartorioComAtribuicoes> cartorios = new ArrayList<>();
        for (Object[] result : results) {
            // Dividir a string de atribuições em uma lista de strings
            String atribuicoesString = (String) result[5];
            List<String> atribuicoesList = Arrays.asList(atribuicoesString.split(","));

            CartorioComAtribuicoes cartorio = new CartorioComAtribuicoes(
                    (Integer) result[0],
                    (String) result[1],
                    (String) result[2],
                    (String) result[3],
                    (String) result[4],
                    atribuicoesList
            );
            cartorios.add(cartorio);
        }
        return cartorios;
    }


}
