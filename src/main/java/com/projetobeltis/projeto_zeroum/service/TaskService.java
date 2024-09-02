package com.projetobeltis.projeto_zeroum.service;

import com.projetobeltis.projeto_zeroum.model.Task;
import com.projetobeltis.projeto_zeroum.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}