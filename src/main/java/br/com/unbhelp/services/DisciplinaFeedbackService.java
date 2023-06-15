package br.com.unbhelp.services;

import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaDAO;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.entities.FeedbackDisciplina;
import dtos.FeedbackDisciplinaDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaFeedbackService {

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

    public List<FeedbackDisciplinaDTO> obterTodosFeedbacks(){
        List<FeedbackDisciplina> feedbacks = dao.findAll();

        return feedbacks.stream().map(feedback -> FeedbackDisciplinaDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    public List<FeedbackDisciplina> obterFeedbackPorDisciplina(){
        Disciplina disciplina = daoDisciplina.findOneByCodigo("0000");
        if(disciplina != null){
            List<FeedbackDisciplina> feedbacks = dao.findAllByDisciplina(disciplina);
            return feedbacks;
        }

        return null;
    }
}
