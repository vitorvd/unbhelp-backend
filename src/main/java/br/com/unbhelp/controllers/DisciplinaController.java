package br.com.unbhelp.controllers;

import br.com.unbhelp.contexto.ContextoManager;
import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dtos.CriarFeedbackDTO;
import br.com.unbhelp.dtos.FeedbackDisciplinaDTO;
import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import br.com.unbhelp.entities.FeedbackDisciplina;
import br.com.unbhelp.services.DisciplinaService;
import br.com.unbhelp.dtos.DisciplinaDTO;
import br.com.unbhelp.services.ProfessorService;
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
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ContextoManager contextoManager;

    @GetMapping("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterFeedbackDisciplinaPorCodigo(@PathVariable String codigo){
        List<FeedbackDisciplinaDTO> feedbacksList = service.obterFeedbackPorDisciplina(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
    }

    @GetMapping("/obter-feedbacks")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTodasDisciplnas(){
        List<FeedbackDisciplinaDTO> disciplinaDTOList = service.obterTodasDisciplinas();

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaDTOList);
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedback(@RequestHeader("authorization") String token, @RequestBody CriarFeedbackDTO feedback){
        try {
            service.criarFeedback(feedback.getDisciplina(), this.contextoManager.obterUsuarioPorToken(token));
            professorService.criarFeedback(feedback.getProfessor(), this.contextoManager.obterUsuarioPorToken(token));
            return ResponseEntity.status(HttpStatus.CREATED).body("Feedback registrado com sucesso!");
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
