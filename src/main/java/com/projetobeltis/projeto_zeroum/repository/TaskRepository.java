package com.projetobeltis.projeto_zeroum.repository;

import com.projetobeltis.projeto_zeroum.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}