package org.helio.cartorioapi.services;

import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartoriosServices {

    private CartoriosRepository repository;

    @Transactional
    public Cartorios saveCartorio(Cartorios cartorios) {
        return repository.save(cartorios);
    }
}
