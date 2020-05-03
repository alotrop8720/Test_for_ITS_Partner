package filters;

import javax.servlet.*;
import java.io.IOException;

public class RoomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("light", request.getParameter("light"));
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
