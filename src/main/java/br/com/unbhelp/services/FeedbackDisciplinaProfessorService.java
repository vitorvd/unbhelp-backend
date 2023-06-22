package br.com.unbhelp.services;

import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dao.FeedbackDisciplinaProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import dtos.FeedbackDisciplinaProfessorDTO;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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


    public List<FeedbackDisciplinaProfessor> obterFeedbacks(FeedbackDisciplinaProfessorDTO dto){
        return this.dao.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(dto.getTexto() != null)
                predicates.add(builder.like(builder.lower(root.get("texto")), dto.getTexto().toLowerCase()));
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }

}
