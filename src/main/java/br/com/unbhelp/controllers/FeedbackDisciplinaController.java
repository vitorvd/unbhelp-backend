package br.com.unbhelp.controllers;

import br.com.unbhelp.entities.FeedbackDisciplina;
import br.com.unbhelp.services.FeedbackDisciplinaService;
import br.com.unbhelp.services.FeedbackDisciplinaService;
import dtos.FeedbackDisciplinaDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/disciplina_feedbacks")
public class FeedbackDisciplinaController {

    @Autowired
    private FeedbackDisciplinaService service;

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedback(@RequestBody FeedbackDisciplinaDTO feedbackDTO){
        service.criarFeedback(feedbackDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackDTO);
    }


    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackPorDisciplina(){
        List<FeedbackDisciplina> feedbacksList = service.obterFeedbackPorDisciplina();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }




}

