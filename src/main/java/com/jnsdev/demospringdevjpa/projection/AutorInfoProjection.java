package com.jnsdev.demospringdevjpa.projection;

/**
 * @Autor Jairo Nascimento
 * @Created 24/11/2024 - 10:49
 */
public class AutorInfoProjection {
    private String nomeCompleto;
    private String cargo;
    private String bio;

    public AutorInfoProjection(String nome, String sobrenome, String cargo, String bio) {
        this.nomeCompleto = nome + " " + sobrenome;
        this.cargo = cargo;
        this.bio = bio;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public String getBio() {
        return bio;
    }
}
