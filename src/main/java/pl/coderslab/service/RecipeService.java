package pl.coderslab.service;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

public class RecipeService {
    //Metoda usuwa przepis o przekazanym ID należący do przekazanego admina oraz zwraca String do wyświetlenia odpowiedniego komunikatu:
    //o pomyślnym usunięciu albo o niepomyślnym usunięciu z powodu braku uprawnień lub wykorzystania przepisu w jednym z planów.
    public static String deleteRecipe(int recipeId, Admin admin) {
        Recipe recipe = RecipeDao.read(recipeId);
        if (recipe.getAdminId() == admin.getId() || admin.getSuperadmin() == 1) {
            if (recipeUsed(recipeId)) {
                return "Przepis nie może być usunięty ponieważ jest częścią planu.";
            } else {
                RecipeDao.delete(recipeId);
                return "Usunięto przepis";
            }
        } else {
            return "Brak uprawnień do usunięcia przepisu.";
        }
    }

    public static boolean recipeUsed(int recipeId) {
        if (RecipePlanDao.instancesOfRecipeUsage(recipeId) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
