package br.com.hackthon.bosque.domain.service;

import br.com.hackthon.bosque.domain.exception.CursoNaoEncontradoException;
import br.com.hackthon.bosque.domain.model.Curso;
import br.com.hackthon.bosque.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCursoService {
    
    @Autowired
    private CursoRepository cursoRepository;
    
    @Transactional
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarOuFalhar(Long cursoId) {
        return cursoRepository.findById(cursoId)
                .orElseThrow(() -> new CursoNaoEncontradoException(cursoId));
    }
}
