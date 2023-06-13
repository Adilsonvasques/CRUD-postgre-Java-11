package com.pccasa.unipar.central.models;

public class Banco {
    private String  nome;
    private String ra;

    public Banco(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public Banco() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", ra='" + ra + '\'' +
                '}';
    }
}
