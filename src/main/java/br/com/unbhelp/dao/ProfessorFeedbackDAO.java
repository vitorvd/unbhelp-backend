package br.com.unbhelp.dao;

import br.com.unbhelp.entities.ProfessorFeedback;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorFeedbackDAO extends DAO<Long, ProfessorFeedback> {

    public ProfessorFeedback findOneById(Long id);

    public List<ProfessorFeedback> findAllByProfessor(Professor id);
}
