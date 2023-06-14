package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Telefone;
import com.pccasa.unipar.central.services.TelefoneService;

import java.sql.SQLException;
import java.util.List;

public class TelefoneController {

    private TelefoneService telefoneService;

    public TelefoneController() {
        telefoneService = new TelefoneService();
    }

    public List<Telefone> getAllTelefone() throws SQLException {
        return telefoneService.findAll();
    }

    public Telefone getTelefoneById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return telefoneService.findById(id);
    }

    public void insertTelefone(Telefone telefone) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        telefoneService.insert(telefone);
    }

    public void updateTelefone(Telefone telefone) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        telefoneService.update(telefone);
    }

    public void deleteTelefone(int id) throws SQLException {
        telefoneService.delete(id);
    }

}
