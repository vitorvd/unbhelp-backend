package dtos;

import br.com.unbhelp.entities.FeedbackDisciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDisciplinaDTO {

    private Long id;

    private String texto;

    private String disciplina_codigo;

    public static FeedbackDisciplinaDTO fromEntity(FeedbackDisciplina feedback){
        FeedbackDisciplinaDTO dto = new FeedbackDisciplinaDTO().builder()
                .id(feedback.getId())
                .texto(feedback.getTexto())
                .build();
        return dto;

    }
}
