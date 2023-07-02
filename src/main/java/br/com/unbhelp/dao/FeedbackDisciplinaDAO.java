package br.com.unbhelp.dao;


import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.entities.FeedbackDisciplina;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDisciplinaDAO extends DAO<Long, FeedbackDisciplina> {

    public FeedbackDisciplina findOneById(Long id);

//    public List<FeedbackDisciplina> findAllByCodigo(Disciplina codigo);
}
