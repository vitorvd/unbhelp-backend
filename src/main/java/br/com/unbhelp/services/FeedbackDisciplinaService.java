package br.com.unbhelp.services;

import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaDAO;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.entities.FeedbackDisciplina;
import dtos.FeedbackDisciplinaDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackDisciplinaService {

    @Autowired
    private FeedbackDisciplinaDAO dao;

    @Autowired
    private DisciplinaDAO daoDisciplina;

    @Transactional
    public FeedbackDisciplinaDTO criarFeedback(FeedbackDisciplinaDTO dto){
        FeedbackDisciplina entidade = FeedbackDisciplina.fromDTO(dto);
        dao.save(entidade);

        return dto;
    }

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<FeedbackDisciplinaDTO> obterTodosFeedbacks(){
        List<FeedbackDisciplina> feedbacks = dao.findAll();

        return feedbacks.stream().map(feedback -> FeedbackDisciplinaDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<FeedbackDisciplina> obterFeedbackPorDisciplina(){
        Disciplina disciplina = daoDisciplina.findOneByCodigo("0000");
        if(disciplina != null){
            List<FeedbackDisciplina> feedbacks = dao.findAllByCodigo(disciplina);
            return feedbacks;
        }
        return null;
    }
}

