package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.DashboardPlanItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name = "Dashboard", value = "/dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int adminId = ((Admin) session.getAttribute("adminID")).getId();
        request.setAttribute("nrOfMeals", RecipeDao.countUserRecipes(adminId));
        request.setAttribute("nrOfPlans", PlanDao.nrOfPlans(adminId));
        request.setAttribute("lastPlanName", PlanDao.lastPlanName(adminId));
        request.setAttribute("lastPlanMon", PlanDao.lastPlanForDay(adminId,1));
        request.setAttribute("lastPlanTue", PlanDao.lastPlanForDay(adminId,2));
        request.setAttribute("lastPlanWed", PlanDao.lastPlanForDay(adminId,3));
        request.setAttribute("lastPlanThu", PlanDao.lastPlanForDay(adminId,4));
        request.setAttribute("lastPlanFri", PlanDao.lastPlanForDay(adminId,5));
        request.setAttribute("lastPlanSat", PlanDao.lastPlanForDay(adminId,6));
        request.setAttribute("lastPlanSun", PlanDao.lastPlanForDay(adminId,7));



        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

