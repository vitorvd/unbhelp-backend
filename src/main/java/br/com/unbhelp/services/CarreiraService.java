package br.com.unbhelp.services;

import br.com.unbhelp.dao.CarreiraDAO;
import br.com.unbhelp.entities.Carreira;
import br.com.unbhelp.entities.Disciplina;
import dtos.CarreiraDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreiraService {

    @Autowired
    private CarreiraDAO dao;

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public CarreiraDTO obterCarreiraPorNome(String nome) throws NotFoundException {
        Carreira entidade = dao.findOneByNome(nome);

        if(entidade == null)
            throw new NotFoundException(String.format("Carreira (%s) não encontrada.", nome));

        return CarreiraDTO.fromEntity(entidade);


    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public List<CarreiraDTO> obterTodasCarreiras(){
        List<Carreira> entidades = dao.findAll();

        return entidades.stream().map(carreira -> CarreiraDTO.fromEntity(carreira)).collect(Collectors.toList());

    }
}
