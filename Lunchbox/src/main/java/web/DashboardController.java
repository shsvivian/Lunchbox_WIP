package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import model.Dish;

@WebServlet("/")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DishDao dishDAO;

	public void init() {
		dishDAO = new DishDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDish(request, response);
				break;
			case "/delete":
				deleteDish(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDish(request, response);
				break;
			default:
				listDish(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listDish(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Dish> dishList = dishDAO.selectAllDishes();
		request.setAttribute("dishList", dishList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard/dashboard.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard/dashboard.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		Dish dish = dishDAO.selectDish(dishId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard/dashboard.jsp");
		request.setAttribute("dish", dish);
		dispatcher.forward(request, response);

	}

	private void insertDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String picture = request.getParameter("picture");
	

		/*
		 * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd"); LocalDate
		 * targetDate = LocalDate.parse(request.getParameter("targetDate"),df);
		 * boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		 */

		Dish dish = new Dish(name, price, description, picture);
		dishDAO.insertDish(dish);
		response.sendRedirect("list");
	}

	private void updateDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int dishId = Integer.parseInt(request.getParameter("dishId"));

		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String picture = request.getParameter("picture");
		
		Dish dish = new Dish(dishId, name, price, description, picture);

		dishDAO.updateDish(dish);

		response.sendRedirect("list");
	}

	private void deleteDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		dishDAO.deleteDish(dishId);
		response.sendRedirect("list");
	}
}
