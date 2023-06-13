package com.pccasa.unipar.central.models;

public class Cidade {
    private Integer id;
    private String nome;
    private String ra;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer id, String nome, String ra, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ra='" + ra + '\'' +
                ", estado=" + estado +
                '}';
    }
}
