package pl.coderslab.web;

import pl.coderslab.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RegiserServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //Load parameters via form and pass data to create new user in service layer.
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if (name == null || name.isBlank() || surname == name || surname.isBlank() || email == null || email.isBlank() || password == null || password.isBlank() || AdminService.isLoginUnique(email)) {
            String errorMessege = "Należy usupełnić dane.";
            if (AdminService.isLoginUnique(email) && !email.isBlank() && email != null) {
                errorMessege = "Użytkownik o adresie email " + email + " istnieje w systemie";
            }
            response.sendRedirect("/register?errorMessege=" + URLEncoder.encode(errorMessege, StandardCharsets.UTF_8));
        } else {
            AdminService.adminRegistration(name, surname, email, password);
            //Redirect to the login page.
            response.sendRedirect("/login");
        }


    }
}
