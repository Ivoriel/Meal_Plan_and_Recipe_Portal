package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.PlanService;
import pl.coderslab.service.RecipeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlanDelete", value = "/app/plan/delete")
public class PlanDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminID");
        String deletionConfirmation = PlanService.deletePlan(Integer.parseInt(request.getParameter("id")), admin);
        session.setAttribute("deletionMessage", deletionConfirmation);
        response.sendRedirect("/app/plan/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
