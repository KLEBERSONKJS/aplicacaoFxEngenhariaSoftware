package com.ads.projetoengenhariasoftware.model;

public enum Genero {
    FEMININO ("feminino"),
    MASCULINO("masculino"),
    TRANSGENERO ("transgenero"),
    OUTRO ("outros"),
    NAOBINARIO ("naobinario");


    private String descricao;

    private Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
