package br.com.unbhelp.controllers;

import br.com.unbhelp.entities.Usuario;
import br.com.unbhelp.services.UsuarioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarUsuario(@RequestBody Usuario usuario){

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario.toString());
    }

}
