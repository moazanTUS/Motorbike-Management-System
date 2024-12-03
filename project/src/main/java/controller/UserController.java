package controller;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private UserDAO userDAO;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    public void init() {
        try {
			userDAO = new UserDAO(DatabaseConnection.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("UserDAO initialized successfully.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            try {
				handleRegister(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if ("login".equals(action)) {
            try {
				handleLogin(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        int userId = userDAO.registerUser(name, password);
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);

        response.sendRedirect("dashboard.jsp");
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userDAO.loginUser(email, password).ifPresentOrElse(userId -> {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            try {
                response.sendRedirect("dashboard.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, () -> {
            request.setAttribute("error", "Invalid login credentials!");
            try {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("logout".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}
