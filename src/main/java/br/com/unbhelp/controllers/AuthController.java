package br.com.unbhelp.controllers;

import br.com.unbhelp.contexto.ContextoManager;
import br.com.unbhelp.entities.Usuario;
import br.com.unbhelp.services.UsuarioService;
import br.com.unbhelp.dtos.UsuarioAuthDTO;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@PermitAll
@Component
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private ContextoManager contextManager;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity auth(@RequestHeader("matricula") String matricula, @RequestHeader("senha") String senha) throws Exception {
        if(matricula == null || senha == null)
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("As credenciais são inválidas.");

        Usuario usuarioLogado = usuarioService.autenticar(matricula, senha);

        String token = matricula + LocalDateTime.now();
        this.contextManager.adicionarToken(token, usuarioLogado);

        UsuarioAuthDTO usuarioAuthDTO = UsuarioAuthDTO.fromEntity(usuarioLogado, token);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioAuthDTO);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestHeader("authorization") String token){
        if(token == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O Token informado não pode ser nulo.");

        this.contextManager.removerToken(token);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
