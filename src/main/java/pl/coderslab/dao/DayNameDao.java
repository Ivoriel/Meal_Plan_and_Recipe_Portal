package pl.coderslab.dao;

import pl.coderslab.model.DayName;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DayNameDao {
    private static final String FIND_ALL_DAYNAMES_QUERY = "SELECT * FROM day_name;";

    /**
     * Return all DayNames
     *
     * @return
     */
    public static List<DayName> findAll() {
        List<DayName> dayNameList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DAYNAMES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DayName dayNameToAdd = new DayName();
                dayNameToAdd.setId(resultSet.getInt("id"));
                dayNameToAdd.setName(resultSet.getString("name"));
                dayNameToAdd.setOrder(resultSet.getInt("display_order"));
                dayNameList.add(dayNameToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayNameList;
    }
}
