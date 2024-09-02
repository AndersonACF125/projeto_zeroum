package com.projetobeltis.projeto_zeroum.beans;

import com.projetobeltis.projeto_zeroum.model.Task;
import com.projetobeltis.projeto_zeroum.repository.TaskDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Named 
@ViewScoped
public class TaskBean {

    @Autowired
    private TaskDAO taskDAO;

    private String title;
    private String description;
    private String priority;
    private double estimate;
    private String searchPriority;

    private List<Task> tasks;

    @PostConstruct
    public void init() {
        tasks = taskDAO.findAll(); // Atualizar para usar findAll()
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate(double estimate) {
        this.estimate = estimate;
    }

    public String getSearchPriority() {
        return searchPriority;
    }

    public void setSearchPriority(String searchPriority) {
        this.searchPriority = searchPriority;
    }

    public List<Task> getTasks() {
        if (searchPriority == null || searchPriority.isEmpty()) {
            return tasks;
        } else {
            return tasks.stream()
                        .filter(task -> searchPriority.equals(task.getPrioridade()))
                        .toList();
        }
    }

    public void addTask() {
        Task newTask = new Task();
        newTask.setTitulo(title);
        newTask.setDescricao(description);
        newTask.setPrioridade(priority);
        newTask.setEstimativaHoras(estimate);

        taskDAO.save(newTask);
        tasks.add(newTask);
        clearFields();
    }

    private void clearFields() {
        title = "";
        description = "";
        priority = "";
        estimate = 0;
    }
}