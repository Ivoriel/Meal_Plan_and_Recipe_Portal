package pl.coderslab.web;

import pl.coderslab.model.Admin;
import pl.coderslab.service.RecipeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeDelete", value = "/app/recipe/delete")
public class RecipeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminID");
        int recipeToDelete = Integer.parseInt(request.getParameter("id"));
        String deletionConfirmation = RecipeService.deleteRecipe(recipeToDelete, admin);
        session.setAttribute("deletionMessage", deletionConfirmation);
        response.sendRedirect("/app/recipe/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
