package br.com.unbhelp.services;

import br.com.unbhelp.dao.FeedbackProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import br.com.unbhelp.dtos.ProfessorDTO;
import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.entities.Usuario;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorDAO dao;

    @Autowired
    private FeedbackProfessorDAO daoFeedback;

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

    @Transactional
    public FeedbackProfessorDTO criarFeedback(FeedbackProfessorDTO dto, Usuario usuario) throws NotFoundException {
        Professor professor = dao.findOneByNome(dto.getNomeCompleto());

        if(professor == null)
            throw new NotFoundException(String.format("Professor (%s) não encontrado.", dto.getNomeCompleto()));

        FeedbackProfessor entidade = FeedbackProfessor.fromDTO(dto);
        entidade.setProfessor(professor);
        entidade.setUsuario(usuario);

        daoFeedback.save(entidade);

        return dto;
    }

    @Transactional
    public List<FeedbackProfessorDTO> obterTodosFeedbacks(){
        List<FeedbackProfessor> feedbacks = daoFeedback.findAll();

        return feedbacks.stream().map(feedback -> FeedbackProfessorDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    @Transactional
    public List<FeedbackProfessorDTO> obterFeedbackPorFiltro(FeedbackProfessorDTO filtro){
        List<FeedbackProfessor> feedbackProfessores = this.daoFeedback.findAll(((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filtro.getNomeCompleto() != null)
                predicates.add(builder.like(builder.lower(root.get("professor").get("nome")), filtro.getNomeCompleto().toLowerCase()));

            predicates.add(builder.equal(root.get("trabalho"), filtro.isTrabalho()));
            predicates.add(builder.equal(root.get("chamada"), filtro.isChamada()));
            predicates.add(builder.equal(root.get("prova"), filtro.isProva()));

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        }));

        List<FeedbackProfessorDTO> dtos = feedbackProfessores.stream().map(fb -> FeedbackProfessorDTO.fromEntity(fb)).collect(Collectors.toList());

        return dtos;
    }


}
