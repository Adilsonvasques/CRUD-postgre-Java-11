package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Banco;
import com.pccasa.unipar.central.services.BancoService;

import java.sql.SQLException;
import java.util.List;

public class BancoController {
    private BancoService bancoService;

    public BancoController() {
        bancoService = new BancoService();
    }

    public List<Banco> getAllBanco() throws SQLException {
        return bancoService.findAll();
    }

    public Banco getBancoById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return bancoService.findById(id);
    }

    public void insertBanco(Banco banco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        bancoService.insert(banco);
    }

    public void updateBanco(Banco banco) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        bancoService.update(banco);
    }

    public void deleteBanco(int id) throws SQLException {
        bancoService.delete(id);
    }
}
