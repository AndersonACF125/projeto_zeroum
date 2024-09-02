package com.projetobeltis.projeto_zeroum.repository;

import com.projetobeltis.projeto_zeroum.model.Task;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Método para listar todas as tarefas
    @Transactional
    public List<Task> findAll() {
        try {
            return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para salvar uma tarefa
    @Transactional
    public void save(Task task) {
        try {
            if (task.getId() == null) {
                entityManager.persist(task);
            } else {
                entityManager.merge(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para encontrar tarefas por ID do projeto
    public List<Task> findByProjectId(Long projectId) {
        try {
            return entityManager.createQuery("SELECT t FROM Task t WHERE t.projeto.id = :projectId", Task.class)
                                .setParameter("projectId", projectId)
                                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para buscar tarefas por prioridade
    public List<Task> findByPriority(String priority) {
        try {
            return entityManager.createQuery("SELECT t FROM Task t WHERE t.prioridade = :priority", Task.class)
                                .setParameter("priority", priority)
                                .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para deletar uma tarefa pelo ID
    @Transactional
    public void deleteById(Long id) {
        try {
            Task task = entityManager.find(Task.class, id);
            if (task != null) {
                entityManager.remove(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}