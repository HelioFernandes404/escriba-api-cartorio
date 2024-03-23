package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150)
    @NotNull
    private String nome;

    @Column(length = 250)
    private String observacao;

    /*
    @ManyToOne
    @JoinColumn(name = "situacao_id")
    private SituacaoCartorio situacao;

    @OneToMany(mappedBy = "cartorio")
    private List<AtribuicaoCartorio> atribuicoes;

    // Getters e Setters
     */
}
