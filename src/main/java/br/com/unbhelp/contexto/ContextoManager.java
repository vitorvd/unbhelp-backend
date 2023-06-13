package br.com.unbhelp.contexto;

import br.com.unbhelp.entities.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ContextoManager {

    private static final String MANAGER_CONTEXT = "CONTEXTO.UNBHELP";

    @Autowired
    private ServletContext servletContext;

    @PostConstruct
    public void init(){
        this.servletContext.setAttribute(MANAGER_CONTEXT, new HashMap<String, Object>());
    }

    public void adicionarToken(String token, Object Usuario) {
        this.getMap().put(token, Usuario);
    }

    public void removerToken(String token) {
        List<String> tokens = this.getMap().entrySet().stream()
                .filter(tokenTemp -> (tokenTemp.getKey()).equals(token))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        tokens.forEach(tokenTemp -> getMap().remove(tokenTemp));
    }

    public boolean existeToken(String token){
        return this.getMap().containsKey(token);
    }

    public Usuario obterUsuarioPorToken(String token) {
        return (Usuario) this.getMap().get(token);
    }

    private Map<String, Object> getMap() {
        return (Map<String, Object>) this.servletContext.getAttribute(MANAGER_CONTEXT);
    }

}
