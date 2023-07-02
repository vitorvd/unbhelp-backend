package br.com.unbhelp.dtos;

import br.com.unbhelp.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarFeedbackDTO {

    private FeedbackDisciplinaDTO disciplina;

    private FeedbackProfessorDTO professor;

}
