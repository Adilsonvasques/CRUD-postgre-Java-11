
package com.pccasa.unipar.central.Exceptions;

public class TamanhoCampoInvalidoException extends Exception{

   
    public TamanhoCampoInvalidoException(String campo,int tamanho) {
        super("O campo " + campo + " foi informado com tamanho(" + tamanho + " caracteres) inválido. Verifique!");
    }
}
