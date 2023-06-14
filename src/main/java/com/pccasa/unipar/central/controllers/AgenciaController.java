package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.services.AgenciaService;

import java.sql.SQLException;
import java.util.List;

public class AgenciaController {

    private AgenciaService agenciaService;

    public AgenciaController() {
        agenciaService = new AgenciaService();
    }

    public List<Agencia> getAllAgencias() throws SQLException {
        return agenciaService.findAll();
    }

    public Agencia getAgenciaById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return agenciaService.findById(id);
    }

    public void insertAgencia(Agencia agencia) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        agenciaService.insert(agencia);
    }

    public void updateAgencia(Agencia agencia) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        agenciaService.update(agencia);
    }

    public void deleteAgencia(int id) throws SQLException {
        agenciaService.delete(id);
    }
}

