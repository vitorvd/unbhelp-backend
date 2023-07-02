package br.com.unbhelp.services;

import br.com.unbhelp.dao.FeedbackProfessorDAO;
import br.com.unbhelp.dao.ProfessorDAO;
import br.com.unbhelp.dtos.FeedbackProfessorDTO;
import br.com.unbhelp.dtos.ProfessorDTO;
import br.com.unbhelp.entities.FeedbackProfessor;
import br.com.unbhelp.entities.Professor;
import br.com.unbhelp.dtos.ProfessorDTO;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.attribute.standard.Media;
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
    public FeedbackProfessorDTO criarFeedback(FeedbackProfessorDTO dto) {
        FeedbackProfessor entidade = FeedbackProfessor.fromDTO(dto);
        daoFeedback.save(entidade);

        return dto;
    }

    @Transactional
    public List<FeedbackProfessorDTO> obterTodosFeedbacks(){
        List<FeedbackProfessor> feedbacks = daoFeedback.findAll();

        return feedbacks.stream().map(feedback -> FeedbackProfessorDTO.fromEntity(feedback)).collect(Collectors.toList());
    }

    @Transactional
    public List<FeedbackProfessor> obterFeedbackPorProfessor(String nome){
        Professor professor = dao.findOneByNome(nome);
        if(professor != null) {
            List<FeedbackProfessor> feedbacks = daoFeedback.findAllByProfessor(professor);
            return feedbacks;
        }
        return null;
    }


}
