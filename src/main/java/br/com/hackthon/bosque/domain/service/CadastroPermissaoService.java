package br.com.hackthon.bosque.domain.service;

import br.com.hackthon.bosque.domain.exception.PermissaoNaoEncontradaException;
import br.com.hackthon.bosque.domain.model.Permissao;
import br.com.hackthon.bosque.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }
}
