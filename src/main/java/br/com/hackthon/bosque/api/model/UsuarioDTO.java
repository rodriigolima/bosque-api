package br.com.hackthon.bosque.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class UsuarioDTO {
    
    private Long id;
    
    private String nome;

    private String email;
    
    private String telefone;
    
    private String nomeEmpresa;
    
    private List<GrupoDTO> grupos;
}
