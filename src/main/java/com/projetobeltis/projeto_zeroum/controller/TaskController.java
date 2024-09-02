package com.projetobeltis.projeto_zeroum.controller;

import com.projetobeltis.projeto_zeroum.model.Task;
import com.projetobeltis.projeto_zeroum.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/saveTask")
    public String saveTask(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("priority") String priority,
            @RequestParam("estimate") String estimateParam,
            Model model) {

        double estimate;
        try {
            estimate = Double.parseDouble(estimateParam);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/error.xhtml";
        }

        Task task = new Task();
        task.setTitulo(title);
        task.setDescricao(description);
        task.setPrioridade(priority);
        task.setEstimativaHoras(estimate);

        taskService.saveTask(task);

        return "redirect:/success.xhtml";
    }
}