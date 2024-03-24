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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String observacao;
    private SituacaosDTO situacao;
    private List<AtribuicaosDTO> atribuicoes;

    public CartoriosDTO(Cartorios entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.observacao = entity.getObservacao();
        this.situacao = new SituacaosDTO(entity.getSituacao());
        this.atribuicoes = entity.getAtribuicoes().stream()
                .map(AtribuicaosDTO::new)
                .collect(Collectors.toList());
    }
}
