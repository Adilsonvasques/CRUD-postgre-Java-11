package com.pccasa.unipar.central.models;

import java.sql.Timestamp;
import java.util.Date;

public class Transacao{
    private Integer id;
    private Timestamp dataHora;
    private Double valor;
    private Integer tipo;
    private String ra;
    private Integer agenciaId;
    private Integer pessoaId;

    public Transacao(Integer id, Timestamp dataHora, Double valor, Integer tipo, String ra, Integer agenciaId, Integer pessoaId) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
        this.tipo = tipo;
        this.ra = ra;
        this.agenciaId = agenciaId;
        this.pessoaId = pessoaId;
    }

    public Transacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
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
        return "Transacao{" +
                "dataHora=" + dataHora +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", ra='" + ra + '\'' +
                ", agencia=" + agenciaId +
                ", pessoa=" + agenciaId +
                '}';
    }
}
