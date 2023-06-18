package br.com.unbhelp.services;

import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.dao.DisciplinaDAO;
import dtos.DisciplinaDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaDAO dao;

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public DisciplinaDTO obterDisciplinaPorCodigo(String codigo) throws NotFoundException{
        Disciplina entidade = dao.findOneByCodigo(codigo);

        if(entidade == null)
            throw new NotFoundException(String.format("Disciplina (%s) não encontrada.", codigo));

        return DisciplinaDTO.fromEntity(entidade);
    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public List<DisciplinaDTO> obterTodasDisciplinas() {
        List<Disciplina> entidades = dao.findAll();

        return entidades.stream().map(disciplina -> DisciplinaDTO.fromEntity(disciplina)).collect(Collectors.toList());
    }

}
