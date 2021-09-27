package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "AdminUserBlock", value = "/app/admin/user/block")
public class AdminUserBlock extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer adminToBlockId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Integer currentAdminId = ((Admin) session.getAttribute("adminID")).getId();
        String messege;
        if (adminToBlockId == currentAdminId) {
            messege = "Nie możesz zablokować sebie.";
        } else {
            AdminService.blockAdmin(adminToBlockId);
            messege = "Użytkownik zablokowany";
        }
        response.sendRedirect("/app/admin/users?message=" + URLEncoder.encode(messege, StandardCharsets.UTF_8));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
