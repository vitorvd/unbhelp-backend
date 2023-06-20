package br.com.unbhelp.services;

import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import br.com.unbhelp.entities.Professor;
import dtos.FeedbackDisciplinaProfessorDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FeedbackDisciplinaProfessorService {

    @Autowired
    private FeedbackDisciplinaProfessorDAO dao;

    @Autowired
    private DisciplinaDAO daoDisciplina;

    @Autowired
    private ProfessorDAO daoProfessor;

    @Transactional
    public FeedbackDisciplinaProfessorDTO criarFeedback(FeedbackDisciplinaProfessorDTO dto){
        FeedbackDisciplinaProfessor entidade = FeedbackDisciplinaProfessor.fromDTO(dto);
        dao.save(entidade);

        return dto;
    }

    @GetMapping
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<FeedbackDisciplinaProfessor> obterFeedbackPorDisciplinaEProfessor(){
        Disciplina disciplina = daoDisciplina.findOneByCodigo("0000");
        Professor professor = daoProfessor.findOneByNome("gabriel");
        if(disciplina != null && professor != null){
            List<FeedbackDisciplinaProfessor> feedbacks = dao.findAllByDisciplinaAndProfessor("0000", "gabriel35");
            return feedbacks;
        }
        return null;
    }


}
