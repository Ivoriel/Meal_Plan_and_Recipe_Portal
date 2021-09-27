package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlanEdit", value = "/app/plan/edit")
public class PlanEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminID");
        if(request.getParameter("planID") != null) {
            try {
                int planId = Integer.parseInt(request.getParameter("planID"));
                Plan plan = PlanDao.read(planId);
                if(plan.getAdminId() == admin.getId()) {
                    session.setAttribute("planID", plan);
                    request.getRequestDispatcher("/app-plan-edit.jsp").forward(request, response);
                } else {
                    response.sendRedirect("\\app/plan/list");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("\\app/plan/list");
            }
        } else {
            response.sendRedirect("\\app/plan/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Plan plan = (Plan) session.getAttribute("planID");
        Admin admin = (Admin) session.getAttribute("adminID");
        if(admin.getId() == plan.getAdminId()) {
            String name = request.getParameter("planName");
            String description = request.getParameter("planDescription");
            plan.setName(name);
            plan.setDescription(description);
            PlanDao.update(plan);
            response.sendRedirect("/app/plan/list");
        }
    }
}
