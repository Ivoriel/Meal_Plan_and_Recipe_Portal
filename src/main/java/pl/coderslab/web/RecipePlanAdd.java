package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RecipePlanAdd", value = "/app/recipe/plan/add")
public class RecipePlanAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        Integer adminId=((Admin) session.getAttribute("adminID")).getId();
        List<Plan> allPlans= PlanDao.findAll(adminId);
        List<Recipe> allRecipes= RecipeDao.findAll(adminId);
        List<DayName> allDays= DayNameDao.findAll();
        session.setAttribute("plans",allPlans);
        session.setAttribute("recipes",allRecipes);
        session.setAttribute("days",allDays);

       request.getRequestDispatcher("/app-recipe-plan-add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        try {
            int planId= Integer.parseInt(request.getParameter("planId"));
            String mealName=request.getParameter("name");
            int displayOrder=Integer.parseInt(request.getParameter("number")) ;
            int recipeId=Integer.parseInt(request.getParameter("recipeId")) ;
            int dayId=Integer.parseInt(request.getParameter("dayId")) ;

            RecipePlan recipePlan=new RecipePlan(recipeId,mealName,displayOrder,dayId,planId);
            RecipePlanDao.create(recipePlan);

        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }finally {
            response.sendRedirect("/app/recipe/plan/add");
        }



    }
}
