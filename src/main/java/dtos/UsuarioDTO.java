package dtos;

import br.com.unbhelp.domains.Curso;
import br.com.unbhelp.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private String matricula;

    private String nomeCompleto;

    private String email;

    private String senha;

    private String apelido;

    private Curso curso;

    public static UsuarioDTO fromEntity(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO().builder()
                .matricula(usuario.getMatricula())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .curso(usuario.getCurso())
                .build();

        return dto;
    }

}
