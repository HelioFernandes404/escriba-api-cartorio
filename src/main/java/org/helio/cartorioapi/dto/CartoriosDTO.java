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
    private int id;

    @Column(length = 150)
    @NotBlank(message = "Campo requerido")
    private String nome;

    @Column(length = 250)
    private String observacao;


    private SituacaosDTO situacao;

    private List<Atribuicaos> atribuicoes;

    public CartoriosDTO(Cartorios entity) {
        id = entity.getId();
        nome = entity.getNome();
        observacao = entity.getObservacao();
        situacao = new SituacaosDTO(entity.getSituacao());

        List<AtribuicaosDTO> atribuicoesDTOs = new ArrayList<>();
        for (Atribuicaos atribuicao : entity.getAtribuicoes()) {
            AtribuicaosDTO atribuicaoDTO = new AtribuicaosDTO(atribuicao.getId(), atribuicao.getNome(), atribuicao.isSituacao());
            atribuicoesDTOs.add(atribuicaoDTO);
        }
        atribuicoes = atribuicoesDTOs.stream().map(x -> new Atribuicaos(x)).collect(Collectors.toList());
    }

}
