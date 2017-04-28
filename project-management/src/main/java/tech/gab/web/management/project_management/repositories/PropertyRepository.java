package tech.gab.web.management.project_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.gab.web.management.project_management.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Long>{

	Property findByName(String name);
}
