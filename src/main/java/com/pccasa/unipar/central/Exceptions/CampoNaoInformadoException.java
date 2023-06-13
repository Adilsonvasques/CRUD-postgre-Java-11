
package com.pccasa.unipar.central.Exceptions;


public class CampoNaoInformadoException extends Exception {

    public CampoNaoInformadoException(String campo) {
        super("O campo " + campo + " não foi informado. Verifique!");
    }
}
