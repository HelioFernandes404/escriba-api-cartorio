package org.helio.cartorioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoCartorioDTO {

    @Id
    @Column(length = 20)
    @NotBlank(message = "Campo requerido")
    private String id;

    @Column(length = 50)
    @NotBlank(message = "Campo requerido")
    private String nome;

    @Column(nullable = false)
    private boolean situacao = true;

    // Construtor de cópia para a classe SituacaoCartorioDTO.
    public SituacaoCartorioDTO(SituacaoCartorioDTO entity) {
        id = entity.getId();
        nome = entity.getNome();
        situacao = entity.isSituacao();
    }
}
