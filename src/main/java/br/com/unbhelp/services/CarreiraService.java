package br.com.unbhelp.services;

import br.com.unbhelp.dao.CarreiraDAO;
import br.com.unbhelp.entities.Carreira;
import br.com.unbhelp.dtos.CarreiraDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreiraService {

    @Autowired
    private CarreiraDAO dao;

    public CarreiraDTO obterCarreiraPorNome(String nome) throws NotFoundException {
        Carreira entidade = dao.findOneByNome(nome);

        if(entidade == null)
            throw new NotFoundException(String.format("Carreira (%s) não encontrada.", nome));

        return CarreiraDTO.fromEntity(entidade);


    }

    public List<CarreiraDTO> obterTodasCarreiras(){
        List<Carreira> entidades = dao.findAll();

        return entidades.stream().map(carreira -> CarreiraDTO.fromEntity(carreira)).collect(Collectors.toList());

    }
}
