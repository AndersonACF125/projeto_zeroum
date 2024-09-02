package com.projetobeltis.projeto_zeroum.controller;

import com.projetobeltis.projeto_zeroum.model.Project;
import com.projetobeltis.projeto_zeroum.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public String listProjects(Model model) {
        List<Project> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "list"; // Nome do arquivo .xhtml
    }

    @PostMapping("/saveproject")
    public ModelAndView saveProject(@RequestParam("title") String title,
                                    @RequestParam("description") String description,
                                    @RequestParam("startDate") String startDate) {
        try {
            // Lógica para salvar o projeto
            projectService.saveProject(title, description, startDate);
            
            // Redireciona para a página de sucesso (ajuste a URL se necessário)
            return new ModelAndView("redirect:/success.xhtml");
        } catch (Exception e) {
            // Em caso de erro, redireciona para uma página de erro (ajuste a URL se necessário)
            return new ModelAndView("redirect:/error.xhtml");
        }
    }

    // Novo método para buscar projetos por título
    @GetMapping("/search")
    public String searchProjects(@RequestParam("title") String title, Model model) {
        List<Project> projects = projectService.findProjectsByTitle(title);
        model.addAttribute("projects", projects);
        return "list"; // Nome do arquivo .xhtml
    }
}