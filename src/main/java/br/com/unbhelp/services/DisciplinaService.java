package br.com.unbhelp.services;

import br.com.unbhelp.dao.FeedbackDisciplinaDAO;
import br.com.unbhelp.dtos.FeedbackDisciplinaDTO;
import br.com.unbhelp.entities.Disciplina;
import br.com.unbhelp.dao.DisciplinaDAO;
import br.com.unbhelp.dtos.DisciplinaDTO;
import br.com.unbhelp.entities.FeedbackDisciplina;
import jakarta.transaction.Transactional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private FeedbackDisciplinaDAO daoFeedback;

    @Autowired
    private DisciplinaDAO daoDisciplina;

    @Autowired
    private DisciplinaDAO dao;

    public DisciplinaDTO obterDisciplinaPorCodigo(String codigo) throws NotFoundException{
        Disciplina entidade = dao.findOneByCodigo(codigo);

        if(entidade == null)
            throw new NotFoundException(String.format("Disciplina (%s) não encontrada.", codigo));

        return DisciplinaDTO.fromEntity(entidade);
    }

    public List<DisciplinaDTO> obterTodasDisciplinas() {
        List<Disciplina> entidades = dao.findAll();

        return entidades.stream().map(disciplina -> DisciplinaDTO.fromEntity(disciplina)).collect(Collectors.toList());
    }

    @Transactional
    public FeedbackDisciplinaDTO criarFeedback(FeedbackDisciplinaDTO dto){
        FeedbackDisciplina entidade = FeedbackDisciplina.fromDTO(dto);

        daoFeedback.save(entidade);

        dto.setId(entidade.getId());
        return dto;
    }
    public List<FeedbackDisciplinaDTO> obterTodosFeedbacks(){
        List<FeedbackDisciplina> feedbacks = daoFeedback.findAll();

        return feedbacks.stream().map(feedback -> FeedbackDisciplinaDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    public List<FeedbackDisciplina> obterFeedbackPorDisciplina(String codigo){
        Disciplina disciplina = daoDisciplina.findOneByCodigo(codigo);
        if(disciplina != null){
            List<FeedbackDisciplina> feedbacks = daoFeedback.findAllByCodigo(disciplina);
            return feedbacks;
        }
        return null;
    }

}
