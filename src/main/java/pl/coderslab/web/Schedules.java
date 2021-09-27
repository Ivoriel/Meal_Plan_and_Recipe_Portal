package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Schedules", value = "/app/plan/list")
public class Schedules extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Admin loggedAdmin = (Admin) session.getAttribute("adminID");
        Integer admin_id = loggedAdmin.getId();
        List<Plan> allPlans= PlanDao.findAll(admin_id);
        session.setAttribute("plans",allPlans);
        request.getRequestDispatcher("/app-plan-list.jsp").forward(request, response);
        //Ustawienie parametru wyświetalającego komunikat po usunięciu planu (potwierzdenie lub zgłoszenie niemożności usunięcia)
        String deletionMessage = (String) session.getAttribute("deletionMessage"); //Pobranie atrybutu z sesji
        if (deletionMessage != null && !deletionMessage.isBlank()) { //Sprawdzenie czy atrybut nie był pusty.
            request.setAttribute("deletionMessage", deletionMessage); //Przekazanie atrybutu z sesji do parametru
            session.removeAttribute("deletionMessage"); //Usunięcie atrybutu z sesji aby wiadomość nie wyświetlała się ponownie po odświeżeniu strony
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
