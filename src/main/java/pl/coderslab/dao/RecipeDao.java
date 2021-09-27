package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Recipe;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    private static final String CREATE_RECIPE_QUERY = "INSERT INTO recipe(name, ingredients, description, created, updated, preparation_time, preparation, admin_id, url_address) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_RECIPE_QUERY = "DELETE FROM recipe where id = ?;";
    private static final String FIND_ALL_ADMIN_RECIPES_QUERY = "SELECT * FROM recipe where admin_id=? ORDER BY id DESC;";
    private static final String FIND_ALL_RECIPES_QUERY = "SELECT * FROM recipe ORDER BY id DESC;";
    private static final String READ_RECIPE_QUERY = "SELECT * FROM recipe WHERE id = ?";
    private static final String UPDATE_RECIPE_QUERY = "UPDATE recipe SET name = ?, ingredients = ?, description = ?, updated = ?, preparation_time = ?, preparation = ?, admin_id = ?, url_address = ? WHERE id = ?;";
    private static final String COUNT_USER_RECIPES_QUERY = "SELECT COUNT(*) AS num FROM recipe WHERE admin_id = ?;";

    /**
     * Get recipe by id
     *
     * @param recipeId
     * @return
     */
    public static Recipe read(Integer recipeId) {
        Recipe recipe = new Recipe();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_QUERY)
        ) {
            statement.setInt(1, recipeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    recipe.setId(resultSet.getInt("id"));
                    recipe.setName(resultSet.getString("name"));
                    recipe.setIngredients(resultSet.getString("ingredients"));
                    recipe.setDescription(resultSet.getString("description"));
                    recipe.setCreated(resultSet.getDate("created"));
                    recipe.setUpdated(resultSet.getDate("updated"));
                    recipe.setPreparationTime(resultSet.getInt("preparation_time"));
                    recipe.setPreparation(resultSet.getString("preparation"));
                    recipe.setAdminId(resultSet.getInt("admin_id"));
                    recipe.setUrlAddress(resultSet.getString("url_address"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipe;

    }
    /**
     * Return all recipes
     *
     * @param adminId
     * @return
     */
    public static List<Recipe> findAll(Integer adminId) {
        List<Recipe> recipeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_ADMIN_RECIPES_QUERY)) {
                statement.setInt(1, adminId);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        Recipe recipeToAdd = new Recipe();
                        recipeToAdd.setId(resultSet.getInt("id"));
                        recipeToAdd.setName(resultSet.getString("name"));
                        recipeToAdd.setIngredients(resultSet.getString("ingredients"));
                        recipeToAdd.setDescription(resultSet.getString("description"));
                        recipeToAdd.setCreated(resultSet.getDate("created"));
                        recipeToAdd.setUpdated(resultSet.getDate("updated"));
                        recipeToAdd.setPreparationTime(resultSet.getInt("preparation_time"));
                        recipeToAdd.setPreparation(resultSet.getString("preparation"));
                        recipeToAdd.setAdminId(resultSet.getInt("admin_id"));
                        recipeToAdd.setUrlAddress(resultSet.getString("url_address"));
                        recipeList.add(recipeToAdd);
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;

    } /**
     * Return all recipes
     *
     * @return
     */
    public static List<Recipe> findAll() {
        List<Recipe> recipeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_RECIPES_QUERY)) {

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        Recipe recipeToAdd = new Recipe();
                        recipeToAdd.setId(resultSet.getInt("id"));
                        recipeToAdd.setName(resultSet.getString("name"));
                        recipeToAdd.setIngredients(resultSet.getString("ingredients"));
                        recipeToAdd.setDescription(resultSet.getString("description"));
                        recipeToAdd.setCreated(resultSet.getDate("created"));
                        recipeToAdd.setUpdated(resultSet.getDate("updated"));
                        recipeToAdd.setPreparationTime(resultSet.getInt("preparation_time"));
                        recipeToAdd.setPreparation(resultSet.getString("preparation"));
                        recipeToAdd.setAdminId(resultSet.getInt("admin_id"));
                        recipeList.add(recipeToAdd);
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipeList;

    }
    /**
     * Create recipe
     *
     * @param recipe
     * @return
     */
    public static Recipe create(Recipe recipe) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_RECIPE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, recipe.getName());
            insertStm.setString(2, recipe.getIngredients());
            insertStm.setString(3, recipe.getDescription());
            insertStm.setDate(4, recipe.getCreated());
            insertStm.setDate(5, recipe.getUpdated());
            insertStm.setInt(6, recipe.getPreparationTime());
            insertStm.setString(7, recipe.getPreparation());
            insertStm.setInt(8, recipe.getAdminId());
            insertStm.setString(9, recipe.getUrlAddress());

            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    recipe.setId(generatedKeys.getInt(1));
                    return recipe;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Remove recipe by id
     *
     * @param recipeId
     */
    public static void delete(Integer recipeId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RECIPE_QUERY)) {
            statement.setInt(1, recipeId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update recipe
     *
     * @param recipe
     */
    public void update(Recipe recipe) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RECIPE_QUERY)) {
            statement.setString(1, recipe.getName());
            statement.setString(2, recipe.getIngredients());
            statement.setString(3, recipe.getDescription());
            statement.setDate(4, new Date(System.currentTimeMillis()));
            statement.setInt(5, recipe.getPreparationTime());
            statement.setString(6, recipe.getPreparation());
            statement.setInt(7, recipe.getAdminId());
            statement.setString(8, recipe.getUrlAddress());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Count user recipes
     *
     * @param adminId
     */
     public static int countUserRecipes(int adminId) {
         int result = 0;
         try (Connection connection = DbUtil.getConnection();
              PreparedStatement statement = connection.prepareStatement(COUNT_USER_RECIPES_QUERY)
         ) {
             statement.setInt(1, adminId);
             try (ResultSet resultSet = statement.executeQuery()) {
                 while (resultSet.next()) {
                     result = resultSet.getInt("num");
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result;
     }
}
