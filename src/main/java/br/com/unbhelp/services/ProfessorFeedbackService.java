package br.com.unbhelp.services;

import br.com.unbhelp.dao.FeedbackProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.entities.Professor;
import dtos.FeedbackProfessorDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorFeedbackService {

    @Autowired
    private FeedbackProfessorDAO dao;

    @Autowired
    private ProfessorDAO daoProfessor;

    @Transactional
    public FeedbackProfessorDTO criarFeedback(FeedbackProfessorDTO dto) {
        FeedbackProfessor entidade = FeedbackProfessor.fromDTO(dto);
        dao.save(entidade);

        return dto;
    }

    public List<FeedbackProfessorDTO> obterTodosFeedbabcks(){
        List<FeedbackProfessor> feedbacks = dao.findAll();

        return feedbacks.stream().map(feedback -> FeedbackProfessorDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    public List<FeedbackProfessor> obterFeedbackPorProfessor(){
        Professor professor = daoProfessor.findOneByNome("gabriel");
        if(professor != null) {
            List<FeedbackProfessor> feedbacks = dao.findAllByProfessor(professor);
            return feedbacks;
        }
        return null;
    }

}
