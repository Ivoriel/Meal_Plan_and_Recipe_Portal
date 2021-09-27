package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Book;
import pl.coderslab.model.DashboardPlanItem;
import pl.coderslab.model.Plan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlanDao {

    // ZAPYTANIA SQL
    private static final String CREATE_PLAN_QUERY = "INSERT INTO plan(name, description, created, admin_id) VALUES (?,?,?,?);";
    private static final String DELETE_PLAN_QUERY = "DELETE FROM plan where id = ?;";
    private static final String FIND_ALL_PLANS_QUERY = "SELECT * FROM plan where admin_id=? ORDER BY id DESC;";
    private static final String READ_PLAN_QUERY = "SELECT * from plan where id = ?;";
    private static final String UPDATE_PLAN_QUERY = "UPDATE	plan SET name=?, description=?,created=?,admin_id=? WHERE	id = ?;";
    private static final String NR_OF_PLANS_QUERY = "SELECT count(*) AS count FROM plan WHERE admin_id = ?;";
    private static final String LAST_PLAN_DAY_QUERY = "SELECT meal_name as mealName,  recipe.name as recipeName, recipe_id as id\n" +
            "FROM `recipe_plan`\n" +
            "         JOIN day_name on day_name.id=day_name_id\n" +
            "         JOIN recipe on recipe.id=recipe_id WHERE\n" +
            "        recipe_plan.plan_id =  (SELECT MAX(id) from plan WHERE admin_id = ?)\n" +
            "         AND day_name_id = ?\n" +
            "ORDER by day_name.display_order, recipe_plan.display_order;";
    private static final String LAST_PLAN_NAME = "SELECT p.name as planName FROM plan p WHERE (admin_id = ? AND (SELECT max(p.created)))\n" +
            "ORDER BY id desc limit 1;";

    /**
     * Get plan by id
     *
     * @param planId
     * @return
     */
    public static Plan read(Integer planId) {

        Plan plan=new Plan();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PLAN_QUERY)
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                    plan.setAdminId(resultSet.getInt("admin_id"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;

    }

    /**
     * Return all plans
     *
     * @param adminId
     * @return
     */

    public static List<Plan> findAll(Integer adminId) {
        List<Plan> planList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLANS_QUERY)) {
            statement.setInt(1, adminId);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Plan plan = new Plan();
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                    plan.setAdminId(resultSet.getInt("admin_id"));
                    planList.add(plan);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planList;

    }


    /**
     * Create plan
     *
     * @param plan
     * @return
     */

    public static Plan create(Plan plan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_PLAN_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, plan.getName());
            insertStm.setString(2, plan.getDescription());
            insertStm.setString(3, plan.getCreated());
            insertStm.setString(4, String.valueOf(plan.getAdminId()));

            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    plan.setId(generatedKeys.getInt(1));
                    return plan;
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
     * Remove plan by id
     *
     * @param planId
     */
    public static void delete(Integer planId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PLAN_QUERY)) {
            statement.setInt(1, planId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Plan not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Update plan
     *
     * @param plan
     */
    public static void update(Plan plan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PLAN_QUERY)) {

            statement.setString(1, plan.getName());
            statement.setString(2, plan.getDescription());
            statement.setString(3, plan.getCreated());
            statement.setString(4, String.valueOf(plan.getAdminId()));
            statement.setString(5, String.valueOf(plan.getId()));

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Last Plan for specific Day
     * returns list of meals for specific day of the week from last created plan (create date max and id max)
     *
     * @param adminId
     * @param dayNr
     */
    public static LinkedList<DashboardPlanItem> lastPlanForDay(Integer adminId, Integer dayNr) {
        LinkedList<DashboardPlanItem> plan = new LinkedList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(LAST_PLAN_DAY_QUERY)
        ) {
            statement.setInt(1, adminId);
            statement.setInt(2, dayNr);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DashboardPlanItem item = new DashboardPlanItem();
                    item.setMealName(resultSet.getString("mealName"));
                    item.setRecipeName(resultSet.getString("recipeName"));
                    item.setId(resultSet.getInt("id"));
                    plan.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;
    }

    /**
     * Last Plan name
     * returns name of last plan (created date last and id max in case there is more plans created the same day
     *
     * @param adminId
     */

    public static String lastPlanName(Integer adminId) {
        String planName = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(LAST_PLAN_NAME)
        ) {
            statement.setInt(1, adminId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    planName = resultSet.getString("planName");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planName;
    }

    /**
     * Total number of plans for specific user
     *
     * @param adminId
     */

    public static Integer nrOfPlans(Integer adminId) {
        Integer count = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(NR_OF_PLANS_QUERY)
        ) {
            statement.setInt(1, adminId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}