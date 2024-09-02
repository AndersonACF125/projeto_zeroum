package com.projetobeltis.projeto_zeroum.repository;

import com.projetobeltis.projeto_zeroum.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}