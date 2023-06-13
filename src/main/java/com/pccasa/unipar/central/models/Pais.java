package com.pccasa.unipar.central.models;

public class Pais {
    private Integer id;
    private String nome;
    private String sigla;
    private String ra;

    public Pais() {
    }

    public Pais(Integer id, String nome, String sigla, String ra) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", ra='" + ra + '\'' +
                '}';
    }
}
