package pl.coderslab.service;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.List;

//Service layer responsible for converting data from Servlet to DAO class.
public class AdminService {

    public static void adminRegistration(String name, String surname, String email, String password) {
        Admin admin = new Admin();
        admin.setFirstName(name);
        admin.setLastName(surname);
        admin.setEmail(email);
        admin.setPassword(password);
        AdminDao.create(admin);
    }

    public static void updateAdmin(Admin admin, String firstName, String lastName, String email) {
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        AdminDao.update(admin);
    }

    public static String updateAdminPassword(Admin admin, String password, String password2) {
        String messege = "Nowe hasło oraz Powtórz hasło muszą być jednakowe";
        if (!password.equals("") && !password2.equals("") && password.equals(password2)) {
            admin.setPassword(password);
            AdminDao.updatePassword(admin);
            messege = "Hasło zostało zmienione";
        }
        return messege;
    }

    public static Boolean isLoginUnique(String email) {
        List<Admin> adminList = AdminDao.findAll();
        for (Admin admin : adminList) {
            if (!admin.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static List<Admin> adminList(Integer adminId) {
        List<Admin> adminList = new ArrayList<>();
        if(AdminDao.isSuperUser(adminId)) {
            for (Admin admin : AdminDao.findAll()) {
                if (admin.getEnable()) {
                    adminList.add(admin);
                }
            }
        }
        return adminList;
    }

    public static void blockAdmin(Integer adminId) {
        Admin admin = AdminDao.read(adminId);
        admin.setEnable(false);
        AdminDao.update(admin);
    }
}
