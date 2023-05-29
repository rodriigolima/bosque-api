package br.com.hackthon.bosque.domain.repository;

import br.com.hackthon.bosque.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {


}
