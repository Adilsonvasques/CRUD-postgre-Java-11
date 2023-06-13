package com.pccasa.unipar.central.models;
public class Pessoa {
    private Integer id;
    private String email;
    private String ra;

    public Pessoa() {
    }

    public Pessoa(Integer id,String email, String ra) {
        this.id = id;
        this.email = email;
        this.ra = ra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "email='" + email + '\'' +
                ", ra='" + ra + '\'' +
                '}';
    }
}
