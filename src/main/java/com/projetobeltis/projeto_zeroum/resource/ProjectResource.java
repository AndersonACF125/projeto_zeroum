package com.projetobeltis.projeto_zeroum.resource;

import com.projetobeltis.projeto_zeroum.model.Project;
import com.projetobeltis.projeto_zeroum.repository.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectResource {

    @Autowired
    private ProjectDAO projectDAO;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectDAO.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectDAO.findById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody Project project) {
        projectDAO.save(project);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project existingProject = projectDAO.findById(id);
        if (existingProject != null) {
            project.setId(id);
            projectDAO.save(project);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectDAO.deleteById(id);
        return ResponseEntity.ok().build();
    }
}