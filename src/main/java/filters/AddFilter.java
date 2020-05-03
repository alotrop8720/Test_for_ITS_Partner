package filters;

import org.apache.commons.io.IOUtils;


import javax.servlet.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;


public class AddFilter implements Filter {
    private static Logger logger = Logger.getLogger(AddFilter.class.getName());
    private static List<String> contents = new LinkedList<>();

    public AddFilter() throws Exception{
        if (contents.size() == 0) {
            try {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Countries.txt");
                String content = "";
                try {
                    content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                contents = Arrays.asList(content.split("\\n"));
                Collections.sort(contents);


            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setAttribute("listCountries", contents);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
