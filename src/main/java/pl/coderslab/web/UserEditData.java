package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;
import pl.coderslab.service.AdminService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEditData", value = "/app/edit/user/data")
public class UserEditData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("admin", session.getAttribute("adminID"));
        request.getRequestDispatcher("/app-edit-user-data.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        if (!firstName.equals("") && !lastName.equals("") && !email.equals("")) {
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("adminID");
            AdminService.updateAdmin(admin, firstName, lastName, email);
            session.setAttribute("adminID", admin);
        }
        response.sendRedirect("/app/edit/user/data");
    }
}
