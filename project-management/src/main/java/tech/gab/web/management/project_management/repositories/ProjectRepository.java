package tech.gab.web.management.project_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.gab.web.management.project_management.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByPep(String pep);
}
