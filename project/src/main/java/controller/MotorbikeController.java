package controller;

import dao.MotorbikeDAO;
import model.Motorbike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/MotorbikeController")
public class MotorbikeController extends HttpServlet {
    private MotorbikeDAO motorbikeDAO;
    private static final Logger logger = Logger.getLogger(MotorbikeController.class.getName());

    public void init() {
        try {
            motorbikeDAO = new MotorbikeDAO(DatabaseConnection.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("MotorbikeDAO initialized successfully.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("addMotorbike".equals(action)) {
            try {
                addNewMotorbike(request, response, userId);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        } else if ("updateMotorbike".equals(action)) {
            try {
                updateExistingMotorbike(request, response, userId);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("viewMyBikes".equals(action)) {
            try {
                showUserMotorbikes(request, response, userId);
            } catch (ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
        } else if ("viewAllBikes".equals(action)) {
            try {
                showAllMotorbikes(request, response);
            } catch (ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
        } else if ("editMotorbike".equals(action)) {
            try {
                loadMotorbikeForEditing(request, response, userId);
            } catch (ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }
        } else if ("deleteMotorbike".equals(action)) {
            try {
                removeMotorbike(request, response, userId);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewMotorbike(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException, SQLException {
        String make = request.getParameter("make");
        String model = request.getParameter("model");

        motorbikeDAO.addMotorbike(userId, make, model);
        response.sendRedirect("MotorbikeController?action=viewMyBikes");
    }

    private void updateExistingMotorbike(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException, SQLException {
        int motorbikeId = Integer.parseInt(request.getParameter("id"));
        String make = request.getParameter("make");
        String model = request.getParameter("model");

        motorbikeDAO.updateMotorbike(motorbikeId, userId, make, model);
        response.sendRedirect("MotorbikeController?action=viewMyBikes");
    }

    private void removeMotorbike(HttpServletRequest request, HttpServletResponse response, int userId) throws IOException, SQLException {
        int motorbikeId = Integer.parseInt(request.getParameter("id"));

        motorbikeDAO.deleteMotorbike(motorbikeId, userId);
        response.sendRedirect("MotorbikeController?action=viewMyBikes");
    }

    private void showUserMotorbikes(HttpServletRequest request, HttpServletResponse response, int userId) throws ServletException, IOException, SQLException {
        List<Motorbike> motorbikes = motorbikeDAO.getUserMotorbikes(userId);
        request.setAttribute("motorbikes", motorbikes);
        request.getRequestDispatcher("viewMyMotorbikes.jsp").forward(request, response);
    }

    private void showAllMotorbikes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<String> motorbikes = motorbikeDAO.getAllMotorbikes();
        request.setAttribute("motorbikes", motorbikes);
        request.getRequestDispatcher("viewAllMotorbikes.jsp").forward(request, response);
    }

    private void loadMotorbikeForEditing(HttpServletRequest request, HttpServletResponse response, int userId) throws ServletException, IOException, SQLException {
        int motorbikeId = Integer.parseInt(request.getParameter("id"));
        String[] motorbike = motorbikeDAO.getMotorbikeById(motorbikeId, userId);

        if (motorbike != null) {
            request.setAttribute("motorbikeId", motorbikeId);
            request.setAttribute("make", motorbike[0]);
            request.setAttribute("model", motorbike[1]);
            request.getRequestDispatcher("updateMotorbike.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Motorbike not found.");
        }
    }
}
