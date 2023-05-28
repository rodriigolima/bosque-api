package br.com.hackthon.bosque.domain.repository;

import br.com.hackthon.bosque.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    
}
