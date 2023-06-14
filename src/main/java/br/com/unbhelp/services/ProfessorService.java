package br.com.unbhelp.services;

import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.Professor;
import dtos.ProfessorDTO;
import dtos.UsuarioDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorDAO dao;

    public ProfessorDTO obterProfessorPorEmailOuNome(String chave) throws NotFoundException {
        Professor entidade = dao.findOneByEmail(chave);

        if(entidade == null)
            entidade = dao.findOneByName(chave);

        if(entidade == null)
            throw new NotFoundException(String.format("Professor (%s) não encontrado.", chave));

        return ProfessorDTO.fromEntity(entidade);


    }

}
