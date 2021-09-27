package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.PlanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPlan", value = "/app/plan/add")
public class AddPlan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/app-add-schedule.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminID");

        //Name and description of plan posted from the Add Plan form.
        String planName = request.getParameter("planName");
        String planDescription = request.getParameter("planDescription");
        PlanService.addPlan(admin.getId(), planName, planDescription);

        response.sendRedirect("/app/plan/list");
    }
}
