package dao;

import java.sql.SQLException;
import java.util.List;

import model.Dish;

public interface DishDao {

	void insertDish(Dish dish) throws SQLException;

	Dish selectDish(long dishId);

	List<Dish> selectAllDishes();

	boolean deleteDish(int id) throws SQLException;

	boolean updateDish(Dish dish) throws SQLException;

}