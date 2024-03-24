package org.helio.cartorioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.helio.cartorioapi.entidades.Atribuicaos;
import org.helio.cartorioapi.entidades.Cartorios;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartoriosDTO {

    private Integer id;
    private String nome;
    private String observacao;
    private SituacaosDTO situacaosDTO;
    private List<AtribuicaosDTO> atribuicoes;

    public CartoriosDTO(Cartorios entity) {

    }

}
