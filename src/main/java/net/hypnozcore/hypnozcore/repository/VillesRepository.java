package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Villes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VillesRepository extends JpaRepository<Villes, String>, JpaSpecificationExecutor<Villes> {
}