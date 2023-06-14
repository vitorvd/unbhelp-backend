package br.com.unbhelp.services;

import br.com.unbhelp.dao.ProfessorFeedbackDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.ProfessorFeedback;
import br.com.unbhelp.entities.Professor;
import dtos.ProfessorFeedbackDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorFeedbackService {

    @Autowired
    private ProfessorFeedbackDAO dao;

    @Autowired
    private ProfessorDAO daoProfessor;

    @Transactional
    public ProfessorFeedbackDTO criarFeedback(ProfessorFeedbackDTO dto) {
       // Feedback entidade = Feedback.fromDTO(dto);
        // dao.save(entidade);

        return dto;
    }

    public List<ProfessorFeedbackDTO> obterTodosFeedbabcks(){
        List<ProfessorFeedback> feedbacks = dao.findAll();

        return feedbacks.stream().map(feedback -> ProfessorFeedbackDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    public List<ProfessorFeedback> obterFeedbackPorProfessor(){
        Professor professor = daoProfessor.findOneByNome("gabriel");
        if(professor != null) {
            List<ProfessorFeedback> feedbacks = dao.findAllByProfessor(professor);
            return feedbacks;
        }
        return null;
    }

    public List<ProfessorFeedbackDTO> obterFeedbackPorDisciplina(){
        return null;
    }

    public List<ProfessorFeedbackDTO> obterFeedbackPorProfessorEDisciplina(){
        return null;
    }
}
