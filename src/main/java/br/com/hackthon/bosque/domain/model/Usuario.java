package br.com.hackthon.bosque.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo genero;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, name = "nome_empresa")
    private String nomeEmpresa;
    
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime", name = "data_cadastro")
    private OffsetDateTime dataCadastro;
    
    @ManyToMany
    @JoinTable(name = "usuario_curso", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursos = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private Set<Grupo> grupos = new HashSet<>();

    public boolean senhaCoincideCom(String senha) {
        return getSenha().equals(senha);
    }

    public boolean senhaNaoCoincideCom(String senha) {
        return !senhaCoincideCom(senha);
    }

    public void removerGrupo(Grupo grupo) {
        getGrupos().remove(grupo);
    }

    public void adicionarGrupo(Grupo grupo) {
        getGrupos().add(grupo);
    }
    
    public void bcryptarSenha() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        senha = encoder.encode(getSenha());
    }
    
}
