package dtos;

import br.com.unbhelp.entities.ProfessorFeedback;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorFeedbackDTO {

    private long id;

    private String text;

    public static ProfessorFeedbackDTO fromEntity(ProfessorFeedback feedback){
        ProfessorFeedbackDTO dto = new ProfessorFeedbackDTO().builder()
                .id(feedback.getId())
                .text(feedback.getText())
                .build();

        return dto;
    }

}
