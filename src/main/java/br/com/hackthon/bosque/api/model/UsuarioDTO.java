package br.com.hackthon.bosque.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Setter@Getter
public class UsuarioDTO {
    
    private Long id;

    private String cpf;
    
    private String nome;

    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    private LocalDate dataNascimento;

    private String genero;
    
    private String telefone;
    
    private String nomeEmpresa;
    
    private List<GrupoDTO> grupos;
}
