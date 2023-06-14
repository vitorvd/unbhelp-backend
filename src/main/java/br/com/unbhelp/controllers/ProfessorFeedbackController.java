package br.com.unbhelp.controllers;

import br.com.unbhelp.entities.ProfessorFeedback;
import br.com.unbhelp.services.ProfessorFeedbackService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/feedbacks")
public class ProfessorFeedbackController {
    @Autowired
    private ProfessorFeedbackService service;


    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackPorProfessor(){
        List<ProfessorFeedback> feedbacksList = service.obterFeedbackPorProfessor();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }
}
