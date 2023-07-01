package br.com.unbhelp.dtos;

import br.com.unbhelp.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UsuarioAuthDTO {

    private String token;

    private String matricula;

    public static UsuarioAuthDTO fromEntity(Usuario user, String token) {
        UsuarioAuthDTO dto = UsuarioAuthDTO.builder().matricula(user.getMatricula()).token(token).build();

        return dto;
    }

}
