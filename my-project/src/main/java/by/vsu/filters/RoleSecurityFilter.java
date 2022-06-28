package by.vsu.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.vsu.models.User;

public abstract class RoleSecurityFilter implements Filter {

    private String role;

    public RoleSecurityFilter(String role) {
        this.role = role;
    }
    
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                               throws IOException, ServletException {
        boolean hasAccess = false;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");

            if (user.getRoles().contains(role)) {
                hasAccess = true;
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

        if (!hasAccess) {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}