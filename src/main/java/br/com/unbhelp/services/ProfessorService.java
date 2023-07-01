package br.com.unbhelp.services;

import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.dtos.ProfessorDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorDAO dao;

    public ProfessorDTO obterProfessorPorEmailOuNome(String chave) throws NotFoundException {
        Professor entidade = dao.findOneByEmail(chave);

        if(entidade == null)
            entidade = dao.findOneByNome(chave);

        if(entidade == null)
            throw new NotFoundException(String.format("Professor (%s) não encontrado.", chave));

        return ProfessorDTO.fromEntity(entidade);


    }

    public ProfessorDTO obterProfessorPorId(Long id, String nome) throws NotFoundException {
        Professor entidade = dao.findOneById(id);

        if(entidade == null)
            entidade = dao.findOneByNome(nome);

        if(entidade == null)
            throw new NotFoundException(String.format("Professor (%s) não encontrado.", nome));

        return ProfessorDTO.fromEntity(entidade);

    }

    public List<ProfessorDTO> obterTodosProfessores(){
        List<Professor> professores = dao.findAll();

        return professores.stream().map(professor -> ProfessorDTO.fromEntity(professor)).collect(Collectors.toList());
    }

}
