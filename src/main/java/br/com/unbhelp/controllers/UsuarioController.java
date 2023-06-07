package br.com.unbhelp.controllers;

import br.com.unbhelp.entities.Usuario;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(){
        Usuario usuario = new Usuario("vitor", "email", "senha", "matricula", "curso", 4.0);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario.toString());
    }

}
