package filters;

import base_classes.GeoIP;
import base_classes.ManagerRooms;
import base_classes.Room;
import base_classes.Utils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ListFilter implements Filter {
    private List<Room> rooms;

    public ListFilter() {
        ManagerRooms managerRooms = new ManagerRooms();
        rooms = managerRooms.getListRoom();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletRequest.setAttribute("rooms", rooms);
        String ip = Utils.getIpAddress(servletRequest.getParameter("data"));
        GeoIP geoIP = new GeoIP(ip);
        servletRequest.setAttribute("ipCountry", geoIP.getCountry());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
