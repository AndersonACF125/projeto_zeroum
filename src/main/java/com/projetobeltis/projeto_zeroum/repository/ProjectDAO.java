package com.projetobeltis.projeto_zeroum.repository;

import com.projetobeltis.projeto_zeroum.model.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Método para listar todos os projetos
    @Transactional
    public List<Project> findAll() {
        try {
            return entityManager.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para salvar um projeto
    @Transactional
    public void save(Project project) {
        try {
            if (project.getId() == null) {
                entityManager.persist(project);
            } else {
                entityManager.merge(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para encontrar um projeto por ID
    public Project findById(Long id) {
        try {
            return entityManager.find(Project.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para deletar um projeto pelo ID
    @Transactional
    public void deleteById(Long id) {
        try {
            Project project = entityManager.find(Project.class, id);
            if (project != null) {
                entityManager.remove(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para buscar projetos por título
    public List<Project> findByTitle(String title) {
        System.out.println("Searching for projects with title: " + title);
        try {
            List<Project> projects = entityManager.createQuery("SELECT p FROM Project p WHERE p.titulo = :title", Project.class)
                                                  .setParameter("title", title)
                                                  .getResultList();
            System.out.println("Found projects: " + projects);
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}