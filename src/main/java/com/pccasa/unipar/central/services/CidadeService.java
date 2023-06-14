package com.pccasa.unipar.central.services;

import com.pccasa.unipar.central.Exceptions.CampoNaoInformadoException;
import com.pccasa.unipar.central.Exceptions.EntidadeNaoInformadaException;
import com.pccasa.unipar.central.Exceptions.TamanhoCampoInvalidoException;
import com.pccasa.unipar.central.models.Cidade;

public class CidadeService {
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(cidade == null){
            throw new EntidadeNaoInformadaException("Cidade");
        }
        
        if(cidade.getNome() == null || 
            cidade.getNome().isBlank() ||
            cidade.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(cidade.getNome().length() > 58){
            throw new TamanhoCampoInvalidoException("Nome",58);
        }

    }
}
