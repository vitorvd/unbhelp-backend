package br.com.unbhelp.services;

import br.com.unbhelp.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Usuario criarUsuario(Usuario usuario) {
        //regras de negócio
        //salvar no banco de dados

        usuario.setSenha(null);
        return usuario;
    }

}
