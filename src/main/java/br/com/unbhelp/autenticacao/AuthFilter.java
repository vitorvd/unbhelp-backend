package br.com.unbhelp.autenticacao;

import br.com.unbhelp.contexto.ContextoManager;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Autowired
    private ContextoManager contextManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().endsWith("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");
        } else {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        }

        if (!request.getRequestURI().contains("auth")) {
            final String token = request.getHeaders("authorization").nextElement();

            if (token == null || !this.contextManager.existeToken(token))
                throw new AuthException("Você não está autenticado na aplicação.");

        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
