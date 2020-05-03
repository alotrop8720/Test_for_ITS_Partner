package servlets;

import base_classes.GeoIP;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IPServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String ip = req.getRemoteAddr();
        GeoIP geoIP = new GeoIP(ip);
        String s = geoIP.getCountry();
        req.setAttribute("ipCountry", geoIP.getCountry());
        resp.sendRedirect(req.getContextPath() + "/view/list.jsp");
    }
}
