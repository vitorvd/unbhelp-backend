package br.com.unbhelp.controllers;

import br.com.unbhelp.domains.UserValidation;
import br.com.unbhelp.services.UsuarioService;
import dtos.UsuarioDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarUsuario(@RequestBody UsuarioDTO usuarioDTO){

        try {
            UserValidation.emailValidate(usuarioDTO.getEmail());
        }catch (InvalidParameterException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

        try {
            UserValidation.passwordValidate(usuarioDTO.getSenha());
        }catch (InvalidParameterException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

        service.criarUsuario(usuarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }
    @GetMapping("/{chave}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterUsuarioPorMatriculaOuEmail(@PathVariable String chave) {
        try {
            UsuarioDTO usuarioDTO = service.obterUsuarioPorMatriculaOuEmail(chave);
            return ResponseEntity.status(HttpStatus.FOUND).body(usuarioDTO);
        }catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PutMapping("/{matricula}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterUsuarioPorMatriculaOuEmail(@PathVariable String matricula, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            service.editarUsuario(matricula, usuarioDTO);
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Usuário (%s) editado.", matricula));
        }catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }


}