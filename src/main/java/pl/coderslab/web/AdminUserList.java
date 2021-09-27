package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminUserList", value = "/app/admin/users")
public class AdminUserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        int adminId = ((Admin) session.getAttribute("adminID")).getId();
        List<Admin> adminList = AdminService.adminList(adminId);
        request.setAttribute("adminList", adminList);

        request.getRequestDispatcher("/super-admin-users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
