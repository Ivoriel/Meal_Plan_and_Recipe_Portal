package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "RecipeList", value = "/app/recipe/list")
public class RecipeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Integer adminId=((Admin) session.getAttribute("adminID")).getId();
        String deletionMessage = (String) session.getAttribute("deletionMessage"); //Pobranie atrybutu z sesji
        if (deletionMessage != null && !deletionMessage.isBlank()) { //Sprawdzenie czy atrybut nie był pusty.
            request.setAttribute("deletionMessage", deletionMessage); //Przekazanie atrybutu z sesji do parametru
            session.removeAttribute("deletionMessage"); //Usunięcie atrybutu z sesji aby wiadomość nie wyświetlała się ponownie po odświeżeniu strony
        }
        List<Recipe> recipeList = RecipeDao.findAll(adminId);
        request.setAttribute("recipeList", recipeList);
        request.getRequestDispatcher("/app-recipes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
