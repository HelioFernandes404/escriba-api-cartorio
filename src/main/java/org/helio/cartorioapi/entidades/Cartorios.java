package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Cartorios {
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
