package servlets;

import base_classes.ManagerRooms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerRooms managerRooms = new ManagerRooms();
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name_room");
        String country = req.getParameter("country");
        managerRooms.createRoom(name, country);
        managerRooms.serialization();
        resp.sendRedirect(req.getContextPath() + "/view/list.jsp");
    }
}
