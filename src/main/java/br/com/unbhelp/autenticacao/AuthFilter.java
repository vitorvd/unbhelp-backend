package br.com.unbhelp.autenticacao;

import br.com.unbhelp.contexto.ContextoManager;
import jakarta.annotation.Priority;
import jakarta.annotation.security.PermitAll;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.annotation.Annotation;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    @Autowired
    private ContextoManager contextManager;

    @Context
    protected HttpServletRequest servletRequest;

    @Context
    protected ResourceInfo resourceInfo;

    @SneakyThrows
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (!this.annotationIsPresent(PermitAll.class) && !containerRequestContext.getMethod().equalsIgnoreCase("OPTIONS")) {
            final String token = containerRequestContext.getHeaderString("authorization");

            if (token == null || !this.contextManager.existeToken(token))
                throw new AuthException("Você não está autenticado na aplicação.");

            this.servletRequest.setAttribute("TOKEN_USER_AUTHORIZATION", token);
            this.servletRequest.setAttribute("TOKEN_USER", this.contextManager.obterUsuarioPorToken(token));
        }
    }

    protected boolean annotationIsPresent(Class<? extends Annotation> annotationClass) {
        return this.resourceInfo.getResourceMethod().isAnnotationPresent(annotationClass) || this.resourceInfo.getResourceClass().isAnnotationPresent(annotationClass);
    }

}
