package br.com.unbhelp.controllers;

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

    @GetMapping("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterDisciplinaPorCodigo(@PathVariable String codigo){

        try{
            DisciplinaDTO disciplinaDTO = service.obterDisciplinaPorCodigo(codigo);
            return ResponseEntity.status(HttpStatus.FOUND).body(disciplinaDTO);
        }catch (NotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/obter-todas")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obterTodasDisciplnas(){
        List<DisciplinaDTO> disciplinaDTOList = service.obterTodasDisciplinas();

        return ResponseEntity.status(HttpStatus.FOUND).body(disciplinaDTOList);
    }

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarFeedback(@RequestBody CriarFeedbackDTO feedback){
        try {
            service.criarFeedback(feedback.getDisciplina());
            professorService.criarFeedback(feedback.getProfessor());
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Feedback registrado com sucesso!");
    }


//    @GetMapping("/{disciplina}")
//    @Consumes(MediaType.APPLICATION_JSON_VALUE)
//    @Produces(MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity obterFeedbackPorDisciplina(@PathVariable String disciplina){
//        List<FeedbackDisciplina> feedbacksList = service.obterFeedbackPorDisciplina(disciplina);
//        return ResponseEntity.status(HttpStatus.OK).body(feedbacksList);
//    }

}
