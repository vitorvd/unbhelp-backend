package br.com.unbhelp.dao;

import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.fachada.DAO;

public interface DisciplinaDAO extends DAO<Long, Disciplina> {

    public Disciplina findOneByCodigo(String codigo);

}
