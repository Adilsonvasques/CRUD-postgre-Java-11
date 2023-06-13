package com.pccasa.unipar.central.models;

public class Telefone {
    private Integer id;
    private String numero;
    private Integer operadora;
    private String ra;
    private Integer agenciaId;
    private Integer pessoaId;

    public String getNumero() {
        return numero;
    }

    public Telefone(Integer id, String numero, Integer operadora, String ra, Integer agenciaId, Integer pessoaId) {
        this.id = id;
        this.numero = numero;
        this.operadora = operadora;
        this.ra = ra;
        this.agenciaId = agenciaId;
        this.pessoaId = pessoaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Telefone() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getOperadora() {
        return operadora;
    }

    public void setOperadora(Integer operadora) {
        this.operadora = operadora;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Integer getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(Integer agenciaId) {
        this.agenciaId = agenciaId;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "numero='" + numero + '\'' +
                ", operadora=" + operadora +
                ", ra='" + ra + '\'' +
                ", agencia=" + agenciaId +
                ", pessoa=" + pessoaId +
                '}';
    }
}
