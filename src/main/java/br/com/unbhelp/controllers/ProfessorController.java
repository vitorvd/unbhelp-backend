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

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTodosFeedbacks(){
        List<FeedbackProfessorDTO> feedbacksList = service.obterTodosFeedbacks();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }

    @PostMapping("/filtro")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbacksPorFiltro(@RequestBody FeedbackProfessorDTO filtro){
        if(filtro.getNomeCompleto() != null && filtro.getNomeCompleto().length() == 0)
            filtro.setNomeCompleto(null);

        List<FeedbackProfessorDTO> feedbacksList = service.obterFeedbackPorFiltro(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }


}
