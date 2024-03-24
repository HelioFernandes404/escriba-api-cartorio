package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.helio.cartorioapi.dto.AtribuicaosDTO;

import java.util.List;
import java.util.Set;


@Data

@NoArgsConstructor

@Entity
@Table(name = "tb_atribuicaos")
@AllArgsConstructor
public class Atribuicaos {
    @Id
    @NotBlank(message = "ID é obrigatório")
    @Size(max = 20, message = "ID deve ter no máximo 20 caracteres")
    private String id;

    @NotBlank(message = "ID é obrigatório")
    @Size(max = 50, message = "ID deve ter no máximo 20 caracteres")
    private String nome;

    @Column(nullable = false)
    private boolean situacao = true;

    @ManyToMany(mappedBy = "atribuicoes")
    @JsonBackReference // Adicionado para evitar serialização circular
    private List<Cartorios> cartorios;

    public Atribuicaos(AtribuicaosDTO dto) {
        id = dto.getId();
        nome = dto.getNome();
        situacao = dto.isSituacao();
    }
}

