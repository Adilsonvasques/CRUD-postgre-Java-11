package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.services.EnderecoService;

import java.sql.SQLException;
import java.util.List;

public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController() {
        enderecoService = new EnderecoService();
    }

    public List<Endereco> getAllEndereco() throws SQLException {
        return enderecoService.findAll();
    }

    public Endereco getEnderecoById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return enderecoService.findById(id);
    }

    public void insertEndereco(Endereco endereco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        enderecoService.insert(endereco);
    }

    public void updateEndereco(Endereco endereco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        enderecoService.update(endereco);
    }

    public void deleteEndereco(int id) throws SQLException {
        enderecoService.delete(id);
    }
}
