package br.com.unbhelp.controllers;

import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.services.ProfessorService;
import br.com.unbhelp.dtos.ProfessorDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;


    @GetMapping("/{chave}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterProfessorPorEmailOuNome(@PathVariable String chave){
        try{
            ProfessorDTO professorDTO = service.obterProfessorPorEmailOuNome(chave);
            return ResponseEntity.status(HttpStatus.FOUND).body(professorDTO);
        }catch(NotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }



    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedback(@RequestBody FeedbackProfessorDTO feedbackDTO){
        service.criarFeedback(feedbackDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackDTO);
    }


    @GetMapping("/{nome}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackPorProfessor(@PathVariable String nome){
        List<FeedbackProfessor> feedbacksList = service.obterFeedbackPorProfessor(nome);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }
}
