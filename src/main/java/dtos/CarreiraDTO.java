package dtos;

import br.com.unbhelp.entities.Carreira;
import br.com.unbhelp.fachada.DAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarreiraDTO  {

    private Long id;

    private String nome;

    public static CarreiraDTO fromEntity(Carreira carreira){
        CarreiraDTO dto = new CarreiraDTO().builder()
                .id(carreira.getId())
                .nome(carreira.getNome())
                .build();
        return dto;
    }
}
