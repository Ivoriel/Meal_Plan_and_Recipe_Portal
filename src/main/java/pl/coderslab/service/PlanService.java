package pl.coderslab.service;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlanService {

    public static String deletePlan(int planId, Admin admin) {
        Plan plan = PlanDao.read(planId);
        if (plan.getAdminId() == admin.getId() || admin.getSuperadmin() == 1) {
            PlanDao.delete(plan.getId());
            return "Usunięto plan";
        } else {
            return "Brak uprawnień do usunięcia planu.";
        }

    }

    public static void addPlan(int adminId, String name, String description) {
        Plan plan = new Plan();
        plan.setName(name);
        plan.setDescription(description);
        plan.setCreated(createdDate());
        plan.setAdminId(adminId);
        PlanDao.create(plan);
    }

    private static String createdDate() {
        LocalDateTime created = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = created.format(dateTimeFormatter);
        return formattedDate;
    }

}
