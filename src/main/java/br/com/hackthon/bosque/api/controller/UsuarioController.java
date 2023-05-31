package br.com.hackthon.bosque.api.controller;

import br.com.hackthon.bosque.api.assembler.UsuarioInputDisassembler;
import br.com.hackthon.bosque.api.assembler.UsuarioModelAssembler;
import br.com.hackthon.bosque.api.model.UsuarioDTO;
import br.com.hackthon.bosque.api.model.UsuarioLoginDTO;
import br.com.hackthon.bosque.api.model.input.LoginResponse;
import br.com.hackthon.bosque.api.model.input.SenhaInput;
import br.com.hackthon.bosque.api.model.input.UsuarioComSenhaInput;
import br.com.hackthon.bosque.api.model.input.UsuarioInput;
import br.com.hackthon.bosque.domain.model.Usuario;
import br.com.hackthon.bosque.domain.repository.UsuarioRepository;
import br.com.hackthon.bosque.domain.service.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;

    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @GetMapping
    public List<UsuarioDTO> listar() { return usuarioModelAssembler.toCollectionModel(usuarioRepository.findAll()); }

    @GetMapping("/{usuarioId}")
    public UsuarioDTO buscar(@PathVariable Long usuarioId){

        Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioLoginDTO> Autentication(@RequestBody Optional<UsuarioLoginDTO> user) {

        return cadastroUsuario.logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

//    @PostMapping("/auth/login")
//    public LoginResponse login(@RequestBody @Validated UsuarioLoginDTO request) {
//        return LoginResponse.builder()
//                .accessToken("BLA BLA BLA")
//                .build();
//    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioInput) {
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);

        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuario)));
    }

    @PutMapping("/{usuarioId}")
    public UsuarioDTO atualizar(@PathVariable Long usuarioId,
                                @RequestBody @Valid UsuarioInput usuarioInput) {

        Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(usuarioId);

        usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);

        return usuarioModelAssembler.toModel(cadastroUsuario.salvar(usuarioAtual));
    }

    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody SenhaInput senha) {
        cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    }

}

