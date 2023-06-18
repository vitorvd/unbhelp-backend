package br.com.unbhelp.dao;

import br.com.unbhelp.entities.Carreira;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.fachada.DAO;

public interface CarreiraDAO extends DAO<Long, Carreira> {

    public Carreira findOneByNome(String nome );
}
