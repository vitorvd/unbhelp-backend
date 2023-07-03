package br.com.unbhelp.services;

import br.com.unbhelp.dao.FeedbackDisciplinaDAO;
import br.com.unbhelp.dtos.DisciplinaDTO;
import br.com.unbhelp.dtos.FeedbackDisciplinaDTO;
import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.entities.FeedbackDisciplina;
import br.com.unbhelp.dtos.DisciplinaDTO;
import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.entities.Usuario;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaDAO dao;

    @Autowired
    private FeedbackDisciplinaDAO daoFeedback;

    public DisciplinaDTO obterDisciplinaPorCodigo(String codigo) throws NotFoundException{
        Disciplina entidade = dao.findOneByCodigo(codigo);

        if(entidade == null)
            throw new NotFoundException(String.format("Disciplina (%s) não encontrada.", codigo));

        return DisciplinaDTO.fromEntity(entidade);
    }

    public List<FeedbackDisciplinaDTO> obterTodasDisciplinas() {
        List<FeedbackDisciplina> entidades = daoFeedback.findAll();

        return entidades.stream().map(disciplina -> FeedbackDisciplinaDTO.fromEntity(disciplina)).collect(Collectors.toList());
    }

    @Transactional
    public FeedbackDisciplinaDTO criarFeedback(FeedbackDisciplinaDTO dto, Usuario usuario) throws NotFoundException {
        Disciplina disciplina = dao.findOneByCodigo(dto.getCodigo());

        if(disciplina == null)
            throw new NotFoundException(String.format("Disciplina (%s) não encontrada.", dto.getCodigo()));

        FeedbackDisciplina entidade = FeedbackDisciplina.fromDTO(dto);
        entidade.setDisciplina(disciplina);
        entidade.setUsuario(usuario);

        daoFeedback.save(entidade);

        dto.setId(entidade.getId());
        return dto;
    }
    public List<FeedbackDisciplinaDTO> obterTodosFeedbacks(){
        List<FeedbackDisciplina> feedbacks = daoFeedback.findAll();

        return feedbacks.stream().map(feedback -> FeedbackDisciplinaDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    public List<FeedbackDisciplinaDTO> obterFeedbackPorDisciplina(String codigo){
        List<FeedbackDisciplina> feedbackDisciplinas = this.daoFeedback.findAll(((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(codigo != null)
                predicates.add(builder.like(builder.lower(root.get("disciplina").get("codigo")), codigo.toLowerCase()));

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        }));

        List<FeedbackDisciplinaDTO> dtos = feedbackDisciplinas.stream().map(fb -> FeedbackDisciplinaDTO.fromEntity(fb)).collect(Collectors.toList());

        return dtos;
    }
}
