package br.com.unbhelp.dao;

import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackProfessorDAO extends DAO<Long, FeedbackProfessor> {

    public FeedbackProfessor findOneById(Long id);

    public List<FeedbackProfessor> findAllByProfessor(Professor nome);
}
