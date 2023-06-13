
package com.pccasa.unipar.central.models;

public class Estado {
    private String nome;
    private String sigla;
    private String ra;
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, String sigla, String ra, Pais pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.ra = ra;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", ra='" + ra + '\'' +
                ", pais=" + pais +
                '}';
    }
}
