package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminPasswordEdit", value = "/app/edit/user/password")
public class AdminPasswordEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getAttribute("messege");
        request.getRequestDispatcher("/app-edit-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminID");
        String messege = AdminService.updateAdminPassword(admin, password, password2);
        request.setAttribute("messege", messege);
        request.getRequestDispatcher("/app-edit-password.jsp").forward(request,response);
    }
}
