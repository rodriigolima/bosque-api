package br.com.hackthon.bosque.api.assembler;

import br.com.hackthon.bosque.api.model.CursoDTO;
import br.com.hackthon.bosque.domain.model.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoModelAssembler {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public CursoDTO toModel(Curso curso) {
        return modelMapper.map(curso, CursoDTO.class);
    }

    public List<CursoDTO> toCollectionModel(List<Curso> cursos) {
        return cursos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
