package com.ads.projetoengenhariasoftware.model;

public enum Raca {

    BRANCO ("branco"),
    PRETO ("preto"),
    PARDO ("pardo"),
    POVOSORIGINARIOS ("povosOriginarios");

    private String descricao;

    private Raca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
