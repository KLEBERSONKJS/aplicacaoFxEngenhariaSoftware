package com.ads.projetoengenhariasoftware.model;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String nome;

    @Column
    private int idade;


    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Raca raca;

    public Pessoa() {

    }

    public Pessoa(String nome, int idade,Genero genero, Raca raca) {
        this.genero = genero;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }

    public Genero getGenero() {
        return genero;
    }

    public Raca getRaca() {
        return raca;
    }

    public String getGeneroString() {
        return genero.toString();
    }
}
