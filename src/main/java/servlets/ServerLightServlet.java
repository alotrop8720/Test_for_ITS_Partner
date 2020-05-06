package servlets;


import base_classes.ManagerRooms;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerLightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.valueOf(request.getParameter("num"));
        ManagerRooms managerRooms = new ManagerRooms();
        managerRooms.getRooms()
                .get(num).setLight(!(managerRooms.getRooms().get(num).isLight()));
        managerRooms.serialization();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerRooms managerRooms = new ManagerRooms();
        boolean lightState = managerRooms.getRooms().get(Integer.valueOf(request.getParameter("num"))).isLight();

        JSONObject responseObj = new JSONObject();
        responseObj.append("light", lightState);
        String responseString = responseObj.toString();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseString);
        out.flush();
    }
}
