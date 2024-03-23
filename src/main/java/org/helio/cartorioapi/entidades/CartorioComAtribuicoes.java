package org.helio.cartorioapi.entidades;

import lombok.Data;

import java.util.List;

@Data
public class CartorioComAtribuicoes {

   
    private Integer id;
    private String cartorioNome;
    private String cartorioObservacao;
    private String situacaoId;
    private String situacaoNome;

    private List<String> atribuicoes;

    // Construtor
    public CartorioComAtribuicoes(Integer cartorioId, String cartorioNome, String cartorioObservacao, String situacaoId, String situacaoNome, List<String> atribuicoes) {
        this.id = cartorioId;
        this.cartorioNome = cartorioNome;
        this.cartorioObservacao = cartorioObservacao;
        this.situacaoId = situacaoId;
        this.situacaoNome = situacaoNome;
        this.atribuicoes = atribuicoes;
    }

    // Getters públicos
    public Integer getId() {
        return id;
    }

    public String getCartorioNome() {
        return cartorioNome;
    }

    public String getCartorioObservacao() {
        return cartorioObservacao;
    }

    public String getSituacaoId() {
        return situacaoId;
    }

    public String getSituacaoNome() {
        return situacaoNome;
    }

    public List<String> getAtribuicoes() {
        return atribuicoes;
    }
}

