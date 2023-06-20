package dtos;

import br.com.unbhelp.entities.FeedbackDisciplina;
import br.com.unbhelp.entities.FeedbackDisciplinaProfessor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDisciplinaProfessorDTO {

    private Long id;

    private String texto;

    private String codigoDisciplina;

    private String nomeProfessor;

    public static FeedbackDisciplinaDTO fromEntity(FeedbackDisciplinaProfessor feedback){
        FeedbackDisciplinaDTO dto = new FeedbackDisciplinaDTO().builder()
                .id(feedback.getId())
                .texto(feedback.getTexto())
                .build();
        return dto;
    }



}
