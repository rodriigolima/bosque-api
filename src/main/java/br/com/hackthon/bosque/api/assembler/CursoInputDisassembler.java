package br.com.hackthon.bosque.api.assembler;

import br.com.hackthon.bosque.api.model.input.CursoInput;
import br.com.hackthon.bosque.domain.model.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Curso toDomainObject(CursoInput cursoInput) {
        return modelMapper.map(cursoInput, Curso.class);
    }

    public void copyToDomainObject(CursoInput cursoInput, Curso curso) {
        modelMapper.map(cursoInput, curso);
    }
}
