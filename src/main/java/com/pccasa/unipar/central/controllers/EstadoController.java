package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.services.EstadoService;

import java.sql.SQLException;
import java.util.List;

public class EstadoController {
    private EstadoService estadoService;

    public EstadoController() {
        estadoService = new EstadoService();
    }

    public List<Estado> getAllEstado() throws SQLException {
        return estadoService.findAll();
    }

    public Estado getEstadoById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return estadoService.findById(id);
    }

    public void insertEstado(Estado estado) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        estadoService.insert(estado);
    }

    public void updateEstado(Estado estado) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        estadoService.update(estado);
    }

    public void deleteEstado(int id) throws SQLException {
        estadoService.delete(id);
    }
}
