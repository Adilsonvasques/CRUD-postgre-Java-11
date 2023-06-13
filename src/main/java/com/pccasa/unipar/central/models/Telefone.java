package com.pccasa.unipar.central.models;

public class Telefone {
    private Integer id;
    private String numero;
    private Integer operadora;
    private String ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public String getNumero() {
        return numero;
    }

    public Telefone(Integer id, String numero, Integer operadora, String ra, Agencia agencia, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.operadora = operadora;
        this.ra = ra;
        this.agencia = agencia;
        this.pessoa = pessoa;
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

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "numero='" + numero + '\'' +
                ", operadora=" + operadora +
                ", ra='" + ra + '\'' +
                ", agencia=" + agencia +
                ", pessoa=" + pessoa +
                '}';
    }
}
