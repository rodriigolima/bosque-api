package br.com.hackthon.bosque.api.model.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Setter@Getter
public class UsuarioInput {
    
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    @CPF
    private String cpf;
    
    private String nomeEmpresa;
    
}
