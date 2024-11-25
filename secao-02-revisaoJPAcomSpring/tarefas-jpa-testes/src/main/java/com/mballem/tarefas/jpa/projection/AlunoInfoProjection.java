package com.mballem.tarefas.jpa.projection;

/**
 * @Autor Jairo Nascimento
 * @Created 25/11/2024 - 14:25
 */
public class AlunoInfoProjection {
    private String nome;
    private int numero;

    public AlunoInfoProjection(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }
}
