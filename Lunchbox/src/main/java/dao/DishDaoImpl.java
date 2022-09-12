package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Dish;
import utils.JDBCUtils;

public class DishDaoImpl implements DishDao {

	private static final String CREATE_DISH = "INSERT INTO dish (name, price, description, picture) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String GET_DISH_BY_ID = "select dish_id, name, price, description, picture from dish where dish_id =?";
	private static final String GET_ALL_DISHES = "select * from dish";
	private static final String DELETE_DISH = "delete from dish where dish_id = ?;";
	private static final String UPDATE_DISH = "update dish set name = ?, price = ?, description =?, picture =? where dish_id = ?;";

	public DishDaoImpl() {
	}

	@Override
	public void insertDish(Dish dish) throws SQLException {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DISH)) {
			preparedStatement.setString(1, dish.getName());
			preparedStatement.setDouble(2, dish.getPrice());
			preparedStatement.setString(3, dish.getDescription());
			preparedStatement.setString(4, dish.getPicture());
//			preparedStatement.setDate(4, JDBCUtils.getSQLDate(menu.getTargetDate()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	@Override
	public Dish selectDish(long dishId) {
		Dish dish = null;

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DISH_BY_ID);) {
			preparedStatement.setLong(1, dishId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				String description = rs.getString("description");
				String picture = rs.getString("picture");
				dish = new Dish(dishId, name, price, description, picture);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}

		return dish;
	}

	@Override
	public List<Dish> selectAllDishes() {
		List<Dish> dishes = new ArrayList<>();

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DISHES);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				String description = rs.getString("description");
				String picture = rs.getString("picture");
				dishes.add(new Dish(id, name, price, description, picture));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}

		return dishes;
	}

	@Override
	public boolean deleteDish(int dishId) throws SQLException {
		boolean rowDeleted;
		
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DISH);) {
			statement.setInt(1, dishId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		
		return rowDeleted;
	}

	@Override
	public boolean updateDish(Dish dish) throws SQLException {
		boolean rowUpdated;
		
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DISH);) {
			statement.setString(1, dish.getName());
			statement.setDouble(2, dish.getPrice());
			statement.setString(3, dish.getDescription());
			statement.setString(4, dish.getPicture());
			statement.setLong(5, dish.getDishId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		
		return rowUpdated;
	}
}
