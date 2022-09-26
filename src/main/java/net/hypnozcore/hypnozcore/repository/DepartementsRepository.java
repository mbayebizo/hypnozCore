package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Departements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementsRepository extends JpaRepository<Departements, String>, JpaSpecificationExecutor<Departements> {
}