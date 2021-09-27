package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRecipe", value = "/app/recipe/add")
public class AddRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/app-add-recipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Integer preparationTime = null;
        try {
            preparationTime = Integer.parseInt(request.getParameter("preparationTime"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        String preparation = request.getParameter("preparation");
        String ingredients = request.getParameter("ingredients");
        String urlAddress = request.getParameter("urlAddress");
        HttpSession session = request.getSession();
        Integer adminId = ((Admin)session.getAttribute("adminID")).getId();
        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        newRecipe.setDescription(description);
        newRecipe.setPreparationTime(preparationTime);
        newRecipe.setPreparation(preparation);
        newRecipe.setIngredients(ingredients);
        newRecipe.setAdminId(adminId);
        newRecipe.setUrlAddress(urlAddress);
        RecipeDao.create(newRecipe);
        response.sendRedirect("/app/recipe/list");

    }
}
