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

    private String codigo;

    private String anoSemestre;

    private String texto;

    private double avaliacao;

    private DisciplinaDTO disciplinaDTO;

    public static FeedbackDisciplinaDTO fromEntity(FeedbackDisciplina feedback){
        FeedbackDisciplinaDTO dto = new FeedbackDisciplinaDTO().builder()
                .id(feedback.getId())
                .texto(feedback.getTexto())
                .anoSemestre(feedback.getAnoSemestre())
                .codigo(feedback.getDisciplina().getCodigo())
                .avaliacao(feedback.getAvaliacao())
                .disciplinaDTO(DisciplinaDTO.fromEntity(feedback.getDisciplina()))
                .build();
        return dto;

    }
}
