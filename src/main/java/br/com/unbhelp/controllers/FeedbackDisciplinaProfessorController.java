package br.com.unbhelp.controllers;

import br.com.unbhelp.dao.FeedbackDisciplinaProfessorDAO;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import br.com.unbhelp.services.FeedbackDisciplinaProfessorService;
import br.com.unbhelp.services.FeedbackDisciplinaService;
import dtos.FeedbackDisciplinaDTO;
import dtos.FeedbackDisciplinaProfessorDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "feedback_disciplina_professor")
public class FeedbackDisciplinaProfessorController {

    @Autowired
    private FeedbackDisciplinaProfessorService service;

    @Autowired
    private FeedbackDisciplinaProfessorDAO dao;

    @PostMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedbackDisciplinaProfessor(@RequestBody FeedbackDisciplinaProfessorDTO feedbackDisciplinaProfessorDTO){
        service.criarFeedback(feedbackDisciplinaProfessorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackDisciplinaProfessorDTO);

    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackPorDisciplinaEProfessor(FeedbackDisciplinaProfessorDTO dto){
        List<FeedbackDisciplinaProfessor> feedbacksList = service.obterFeedbacks(dto);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }

}
