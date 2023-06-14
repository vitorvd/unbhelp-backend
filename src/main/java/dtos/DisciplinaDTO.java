package dtos;

import br.com.unbhelp.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaDTO {

    private String codigo;

    private String nome;

    private String ementa;

    private double avaliacao;

    public static DisciplinaDTO fromEntity(Disciplina disciplina){
        DisciplinaDTO dto = new DisciplinaDTO().builder()
                .codigo(disciplina.getCodigo())
                .nome(disciplina.getNome())
                .ementa(disciplina.getEmenta())
                .avaliacao(disciplina.getAvaliacao())
                .build();

        return dto;
    }

}
