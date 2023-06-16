package br.com.unbhelp.services;

import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import dtos.FeedbackDisciplinaProfessorDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackDisciplinaProfessorService {

    @Autowired
    private FeedbackDisciplinaProfessorDAO dao;

    @Autowired
    private DisciplinaDAO daoDisciplina;

    @Autowired
    private ProfessorDAO daoProfessor;

    @Transactional
    public FeedbackDisciplinaProfessorDTO criarFeedback(FeedbackDisciplinaProfessorDTO dto){
        FeedbackDisciplinaProfessor entidade = FeedbackDisciplinaProfessor.fromDTO(dto);
        dao.save(entidade);

        return dto;
    }
}
