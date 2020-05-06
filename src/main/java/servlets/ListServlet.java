package servlets;

import base_classes.GeoIP;
import base_classes.Utils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject responseObj = new JSONObject();
        String ip = Utils.getIpAddress(request.getParameter("data"));
        GeoIP geoIP = new GeoIP(ip);
        responseObj.append("ipCountry", geoIP.getCountry());
        String responseString = responseObj.toString();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseString);
        out.flush();
    }
}
