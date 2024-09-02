package com.projetobeltis.projeto_zeroum.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/saveTask")
public class SaveTaskServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/beltis";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");
        String estimateParam = request.getParameter("estimate");

        // Verificar e converter o parâmetro estimate para decimal
        double estimate;
        try {
            estimate = Double.parseDouble(estimateParam);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.xhtml");
            return;
        }

        String sql = "INSERT INTO tarefa (titulo, descricao, prioridade, estimativa_horas) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, priority);
            statement.setDouble(4, estimate);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                response.sendRedirect("success.xhtml");
            } else {
                response.sendRedirect("error.xhtml");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.xhtml");
        }
    }
}