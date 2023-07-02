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

    private String text;

    private String professor;

    private ProfessorDTO professorDTO;

    public static FeedbackProfessorDTO fromEntity(FeedbackProfessor feedback){
        FeedbackProfessorDTO dto = new FeedbackProfessorDTO().builder()
                .id(feedback.getId())
                .text(feedback.getText())
                .professorDTO(ProfessorDTO.fromEntity(feedback.getProfessor()))
                .build();

        return dto;
    }

}