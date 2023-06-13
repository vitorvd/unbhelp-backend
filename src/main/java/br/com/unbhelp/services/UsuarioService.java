package br.com.unbhelp.services;

import br.com.unbhelp.dao.UsuarioDAO;
import br.com.unbhelp.entities.Usuario;
import dtos.UsuarioDTO;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario entidade = Usuario.fromDTO(dto);
        dao.save(entidade);

        dto.setSenha(null);
        return dto;
    }

    public UsuarioDTO obterUsuarioPorMatriculaOuEmail(String chave) throws NotFoundException {
        Usuario entidade = dao.findOneByMatricula(chave);

        if(entidade == null)
            entidade = dao.findOneByEmail(chave);

        if(entidade == null)
            throw new NotFoundException(String.format("Usuário (%s) não encontrado.", chave));

        return UsuarioDTO.fromEntity(entidade);
    }

}
