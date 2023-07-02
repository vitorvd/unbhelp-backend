package br.com.unbhelp.dtos;

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

    private String codigoDisciplina;

    private DisciplinaDTO disciplinaDTO;

    public static FeedbackDisciplinaDTO fromEntity(FeedbackDisciplina feedback){
        FeedbackDisciplinaDTO dto = new FeedbackDisciplinaDTO().builder()
                .id(feedback.getId())
                .texto(feedback.getTexto())
                .disciplinaDTO(DisciplinaDTO.fromEntity(feedback.getCodigo()))
                .build();
        return dto;

    }
}
