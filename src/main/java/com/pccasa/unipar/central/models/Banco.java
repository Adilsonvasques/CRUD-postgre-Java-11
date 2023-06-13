package com.pccasa.unipar.central.models;

public class Banco {
    private Integer id;
    private String  nome;
    private String ra;

    public Banco(Integer id, String nome, String ra) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
