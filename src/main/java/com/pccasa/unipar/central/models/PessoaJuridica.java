package com.pccasa.unipar.central.models;

public class PessoaJuridica extends Pessoa{

    private String razaoSocial;
    private String cnpj;
    private String cnaPrincipal;
    private String fantasia;
    private Pessoa pessoa;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String cnpj, String cnaPrincipal, String fantasia, Pessoa pessoa) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnaPrincipal = cnaPrincipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnaPrincipal() {
        return cnaPrincipal;
    }

    public void setCnaPrincipal(String cnaPrincipal) {
        this.cnaPrincipal = cnaPrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cnaPrincipal='" + cnaPrincipal + '\'' +
                ", fantasia='" + fantasia + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
