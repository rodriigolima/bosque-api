package br.com.hackthon.bosque.domain.service;

import br.com.hackthon.bosque.domain.exception.NegocioException;
import br.com.hackthon.bosque.domain.exception.UsuarioNaoEncontradoException;
import br.com.hackthon.bosque.domain.model.Grupo;
import br.com.hackthon.bosque.domain.model.Usuario;
import br.com.hackthon.bosque.api.model.UsuarioLoginDTO;
import br.com.hackthon.bosque.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Optional;

@Service
public class CadastroUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CadastroGrupoService cadastroGrupo;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detach(usuario);
        
        verificarExistenciaEmail(usuario);
        verificarExistenciaCpf(usuario);

        usuario.bcryptarSenha();

        return usuarioRepository.save(usuario);
    }

    
    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }

        usuario.setSenha(novaSenha);
    }

    private void verificarExistenciaEmail(Usuario usuario) {
        Optional<Usuario> usuarioExistenteEmail = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistenteEmail.isPresent() && !usuarioExistenteEmail.get().equals(usuario)) {
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
        }
    }

    private void verificarExistenciaCpf(Usuario usuario) {
        Optional<Usuario> usuarioExistenteCpf = usuarioRepository.findByCpf(usuario.getCpf());

        if (usuarioExistenteCpf.isPresent() && !usuarioExistenteCpf.get().equals(usuario)) {
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o CPF %s", usuario.getCpf()));
        }
    }

    @Transactional
    public void desassociarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);

        usuario.removerGrupo(grupo);
    }

    @Transactional
    public void associarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);

        usuario.adicionarGrupo(grupo);

    }

    @Transactional
    public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = usuarioRepository.findByEmail(user.get().getEmail());

        if (usuario.isPresent()) {
            if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
                String auth = user.get().getEmail() + ":" + user.get().getSenha();
                byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setNome(usuario.get().getNome());
                user.get().setEmail(usuario.get().getEmail());
                user.get().setGrupos(usuario.get().getGrupos().toString());

                return user;
            }
        }
        return Optional.empty();
    }
    
    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }
   
}
