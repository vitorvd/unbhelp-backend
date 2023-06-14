package br.com.unbhelp.dao;

import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDAO extends DAO<Long, Professor> {

    public Professor findOneByEmail(String email);

    public Professor findOneByName(String Nome);
}
