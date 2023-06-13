package br.com.unbhelp.dao;

import br.com.unbhelp.entities.Usuario;
import br.com.unbhelp.fachada.DAO;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends DAO<Long, Usuario> {

    public Usuario findOneByMatricula(String matricula);

    public Usuario findOneByEmail(String email);

}
