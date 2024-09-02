package com.projetobeltis.projeto_zeroum.beans;

import com.projetobeltis.projeto_zeroum.model.Project;
import com.projetobeltis.projeto_zeroum.repository.ProjectDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class ProjectBean {

    @Autowired
    private ProjectDAO projectDAO;

    private String title;
    private String description;
    private Date startDate; // Alterado para Date

    private List<Project> projects;
    private List<Project> filteredProjects;

    @PostConstruct
    public void init() {
        // Inicializar a lista de projetos
        projects = projectDAO.findAll();
        filteredProjects = projects;
    }

    public void addProject() {
        try {
            // Criação e configuração do novo projeto
            Project newProject = new Project();
            newProject.setTitulo(title); // Alterado para 'titulo'
            newProject.setDescricao(description); // Alterado para 'descricao'
            newProject.setDataInicio(startDate); // Alterado para 'dataInicio'

            // Salvamento do projeto
            projectDAO.save(newProject);

            // Atualização da lista de projetos
            projects.add(newProject);
            filteredProjects = projects; // Atualizar lista filtrada

            // Limpeza dos campos
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
            // Adicionar lógica de tratamento de erros, se necessário
        }
    }

    public void searchProjects() {
        filteredProjects = projects.stream()
            .filter(project -> (title == null || project.getTitulo().toLowerCase().contains(title.toLowerCase())) &&
                               (description == null || project.getDescricao().toLowerCase().contains(description.toLowerCase())) &&
                               (startDate == null || project.getDataInicio().equals(startDate)))
            .collect(Collectors.toList());
    }

    private void clearFields() {
        title = "";
        description = "";
        startDate = null; // Limpeza de Date
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Project> getFilteredProjects() {
        return filteredProjects;
    }

    public void setFilteredProjects(List<Project> filteredProjects) {
        this.filteredProjects = filteredProjects;
    }
}