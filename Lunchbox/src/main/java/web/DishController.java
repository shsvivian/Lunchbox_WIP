package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DishDao;
import model.Dish;

@WebServlet(urlPatterns = { "/dish", "/dish/new", "/dish/insert", "/dish/edit", "/dish/update", "/dish/delete",
		"/dish/list" })
public class DishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DishDao dishDAO;

	public void init() {
		dishDAO = new DishDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action: " + action);

		try {
			switch (action) {
			case "/dish/new":
				showNewForm(request, response);
				break;
			case "/dish/insert":
				insertDish(request, response);
				break;
			case "/dish/edit":
				showEditForm(request, response);
				break;
			case "/dish/update":
				updateDish(request, response);
				break;
			case "/dish/delete":
				deleteDish(request, response);
				break;
			case "/dish/list":
				listDish(request, response);
				break;
			default:
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
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
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int dishId = Integer.parseInt(request.getParameter("dishId"));
		Dish dish = dishDAO.selectDish(dishId);

		request.setAttribute("dish", dish);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}

	private void insertDish(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String picture = request.getParameter("picture");

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
		System.out.println("dishId: " + dishId);
		dishDAO.deleteDish(dishId);
		response.sendRedirect("list");
	}
}
