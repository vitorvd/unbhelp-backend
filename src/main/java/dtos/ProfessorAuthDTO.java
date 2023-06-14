package dtos;

import br.com.unbhelp.entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProfessorAuthDTO {

    private String token;

    private String email;

    public static ProfessorAuthDTO fromEntity(Professor professor, String token){
        ProfessorAuthDTO dto = ProfessorAuthDTO.builder()
                .email(professor.getEmail())
                .token(token)
                .build();
        return dto;
    }
}
