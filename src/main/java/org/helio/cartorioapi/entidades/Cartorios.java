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


    private boolean situacao;


    @OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atribuicaos> atribuicoes;
}
