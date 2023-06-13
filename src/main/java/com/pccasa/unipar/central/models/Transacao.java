package com.pccasa.unipar.central.models;

import java.util.Date;

public class Transacao{
    private Date dataHora;
    private Double valor;
    private Integer tipo;
    private String ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public Transacao(Date dataHora, Double valor, Integer tipo, String ra, Agencia agencia, Pessoa pessoa) {
        this.dataHora = dataHora;
        this.valor = valor;
        this.tipo = tipo;
        this.ra = ra;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public Transacao() {
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        return "Transacao{" +
                "dataHora=" + dataHora +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", ra='" + ra + '\'' +
                ", agencia=" + agencia +
                ", pessoa=" + pessoa +
                '}';
    }
}
