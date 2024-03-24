package org.helio.cartorioapi.services;

import org.helio.cartorioapi.dto.CartoriosMinDTO;
import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartoriosServices {

    @Autowired
    private CartoriosRepository repository;

    public Cartorios getbyId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Page<CartoriosMinDTO> findAll(Pageable pageable) {
        Page<Cartorios> result = repository.findAllBy(pageable);
        return result.map(x -> new CartoriosMinDTO(x));
    }
}
