package com.pccasa.unipar.central.controllers;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.services.PaisService;

import java.sql.SQLException;
import java.util.List;

public class PaisController {
    private PaisService paisService;

    public PaisController() {
        paisService = new PaisService();
    }

    public List<Pais> getAllPais() throws SQLException {
        return paisService.findAll();
    }

    public Pais getPaisById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {
        return paisService.findById(id);
    }

    public void insertPais(Pais pais) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        paisService.insert(pais);
    }

    public void updatePais(Pais pais) throws SQLException, EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {
        paisService.update(pais);
    }

    public void deletePais(int id) throws SQLException {
        paisService.delete(id);
    }

}
