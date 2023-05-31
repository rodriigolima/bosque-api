package br.com.hackthon.bosque.api.model.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Setter@Getter
public class UsuarioInput {

    @NotBlank
    @CPF
    private String cpf;
    
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @PastOrPresent
    private LocalDate dataNascimento;

    @NotBlank
    private String genero;

    @NotBlank
    private String telefone;
    
    private String nomeEmpresa;
    
}
