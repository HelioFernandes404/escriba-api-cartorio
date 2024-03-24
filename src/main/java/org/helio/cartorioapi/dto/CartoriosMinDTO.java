package org.helio.cartorioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.helio.cartorioapi.entidades.Cartorios;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartoriosMinDTO {

    private int id;

    private String nome;

    public CartoriosMinDTO(Cartorios entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
}
