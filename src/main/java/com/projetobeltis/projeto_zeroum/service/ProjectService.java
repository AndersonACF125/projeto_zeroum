package com.projetobeltis.projeto_zeroum.service;

import com.projetobeltis.projeto_zeroum.model.Project;
import com.projetobeltis.projeto_zeroum.repository.ProjectDAO;
import com.projetobeltis.projeto_zeroum.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ProjectRepository projectRepository;

    // Método existente para salvar projeto
    public void saveProject(String title, String description, String startDate) throws ParseException {
        // Conversão da string startDate para Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(startDate);

        // Criação do objeto Project
        Project project = new Project();
        project.setTitulo(title); // Corrigido para usar 'titulo' conforme a tabela
        project.setDescricao(description); // Corrigido para usar 'descricao' conforme a tabela
        project.setDataInicio(date); // Corrigido para usar 'data_inicio' conforme a tabela

        // Salvamento do projeto no banco de dados
        projectRepository.save(project);

        // Log para depuração
        System.out.println("Project saved: " + title + ", " + description + ", " + startDate);
    }

    // Método para listar todos os projetos
    public List<Project> findAllProjects() {
        return projectDAO.findAll();
    }

    // Método para encontrar um projeto por ID
    public Project findProjectById(Long id) {
        return projectDAO.findById(id);
    }

    // Método para deletar um projeto pelo ID
    public void deleteProjectById(Long id) {
        projectDAO.deleteById(id);
    }

    // Novo método para buscar projetos por título
    public List<Project> findProjectsByTitle(String title) {
        return projectDAO.findByTitle(title);
    }
}