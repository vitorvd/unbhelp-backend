package br.com.unbhelp.fachada;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DAO<ID, E> extends JpaRepository<E, ID>, DAOConsultar<ID, E> {
}
