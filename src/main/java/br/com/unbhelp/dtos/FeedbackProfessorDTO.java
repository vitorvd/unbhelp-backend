package br.com.unbhelp.dtos;

import br.com.unbhelp.entities.FeedbackProfessor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackProfessorDTO {

    private Long id;

    private String nomeCompleto;

    private boolean chamada;

    private boolean trabalho;

    private boolean prova;

    private double avaliacao;

    private String explicacao;

    private UsuarioDTO usuario;

    private ProfessorDTO professorDTO;

    public static FeedbackProfessorDTO fromEntity(FeedbackProfessor feedback){
        FeedbackProfessorDTO dto = new FeedbackProfessorDTO().builder()
                .id(feedback.getId())
                .chamada(feedback.isChamada())
                .trabalho(feedback.isTrabalho())
                .prova(feedback.isProva())
                .avaliacao(feedback.getAvaliacao())
                .explicacao(feedback.getExplicacao())
                .nomeCompleto(feedback.getProfessor().getNome())
                .usuario(UsuarioDTO.fromEntity(feedback.getUsuario()))
                .professorDTO(ProfessorDTO.fromEntity(feedback.getProfessor()))
                .build();

        return dto;
    }

}
