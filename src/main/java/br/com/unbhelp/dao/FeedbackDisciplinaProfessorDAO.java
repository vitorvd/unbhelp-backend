package br.com.unbhelp.dao;

import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDisciplinaProfessorDAO extends DAO<Long, FeedbackDisciplinaProfessor> {

    public List<FeedbackDisciplinaProfessor> findAllByDisciplinaAndProfessor(String codigoDisciplina, String nomeProfessor);


}
