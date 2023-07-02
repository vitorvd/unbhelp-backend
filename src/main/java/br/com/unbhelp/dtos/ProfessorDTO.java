package br.com.unbhelp.dtos;

import br.com.unbhelp.entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;

    private String email;

    private String nome;

    private double avaliacao;

    public static ProfessorDTO fromEntity(Professor professor){
        ProfessorDTO dto = new ProfessorDTO().builder()
                .id(professor.getId())
                .email(professor.getEmail())
                .nome(professor.getNome())
                .avaliacao(professor.getAvaliacao())
                .build();
        return dto;
    }
}
