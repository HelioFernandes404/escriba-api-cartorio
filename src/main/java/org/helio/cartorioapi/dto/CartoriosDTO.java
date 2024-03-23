package org.helio.cartorioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.helio.cartorioapi.entidades.Atribuicaos;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "situacao_id", nullable = false)
    private SituacaosDTO situacao;

    @OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atribuicaos> atribuicoes;
}
