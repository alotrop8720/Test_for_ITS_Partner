package filters;

import javax.servlet.*;
import java.io.IOException;

public class RoomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("country", request.getParameter("country"));
        request.setAttribute("light", request.getParameter("light"));
        request.setAttribute("num", request.getParameter("num"));
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
