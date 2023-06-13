
package com.pccasa.unipar.central.models;

public class Conta {
    private Integer id;
    private String numero;
    private String digito;
    private Double saldo;
    private Integer tipo;
    private String ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(Integer id, String numero, String digito, Double saldo, Integer tipo, String ra, Agencia agencia, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipo = tipo;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
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
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", digito='" + digito + '\'' +
                ", saldo=" + saldo +
                ", tipo=" + tipo +
                ", ra='" + ra + '\'' +
                ", agencia=" + agencia +
                ", pessoa=" + pessoa +
                '}';
    }
}
