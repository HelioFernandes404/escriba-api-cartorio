package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_cartorios")
public class Cartorios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150)
    @NotNull
    private String nome;

    @Column(length = 250)
    private String observacao;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Situacaos situacao;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_atribuica_cartorio",
            joinColumns = @JoinColumn(name = "atribuicao_cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "atribuicoes_id"))
    private List<Atribuicaos> atribuicoes;
}
