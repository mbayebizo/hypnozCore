package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Devise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, String>, JpaSpecificationExecutor<Devise> {
}