package com.projetobeltis.projeto_zeroum.servlet;

import com.projetobeltis.projeto_zeroum.model.Project;
import com.projetobeltis.projeto_zeroum.repository.ProjectDAO;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ProjectServlet extends HttpServlet {

    @Inject
    private ProjectDAO projectDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar a lista de projetos do banco de dados
        List<Project> projects = projectDAO.findAll();

        // Atribuir a lista de projetos ao request
        req.setAttribute("projects", projects);

        // Encaminhar para a página de visualização
        req.getRequestDispatcher("/view.xhtml").forward(req, resp);
    }
}