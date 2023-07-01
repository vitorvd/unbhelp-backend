package br.com.unbhelp.controllers;

import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.services.FeedbackProfessorService;
import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professor_feedbacks")
public class FeedbackProfessorController {
    @Autowired
    private FeedbackProfessorService service;

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedback(@RequestBody FeedbackProfessorDTO feedbackDTO){
        service.criarFeedback(feedbackDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackDTO);
    }


    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackPorProfessor(){
        List<FeedbackProfessor> feedbacksList = service.obterFeedbackPorProfessor();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }
}
