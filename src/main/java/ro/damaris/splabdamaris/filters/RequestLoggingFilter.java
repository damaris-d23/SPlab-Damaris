package ro.damaris.splabdamaris.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("Starting processing request: {} {}", req.getMethod(), req.getRequestURI());

        // Pasează cererea mai departe în "lanț" (către următorul filtru sau controller)
        chain.doFilter(request, response);

        logger.info("Finished processing request: {} {}", req.getMethod(), req.getRequestURI());
    }
}