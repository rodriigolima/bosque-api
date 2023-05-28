package br.com.hackthon.bosque.domain.exception;

public class CursoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public static final String MSG_CURSO_NAO_ENCONTRADO = "Não existe um cadastro de curso com código %d";
    
    public CursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public CursoNaoEncontradoException(Long cursoId) {
        this(String.format(MSG_CURSO_NAO_ENCONTRADO, cursoId));
    }
    

}