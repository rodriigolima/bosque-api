package br.com.hackthon.bosque.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
    
    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
