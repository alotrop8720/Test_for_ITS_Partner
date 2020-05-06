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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        ManagerRooms managerRooms = new ManagerRooms();
        rooms = managerRooms.getListRoom();
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("rooms", rooms);
        String ip = Utils.getIpAddress(request.getParameter("data"));
        GeoIP geoIP = new GeoIP(ip);
        request.setAttribute("ipCountry", geoIP.getCountry());
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
