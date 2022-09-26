package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Cellules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CellulesRepository extends JpaRepository<Cellules, Long>, JpaSpecificationExecutor<Cellules> {
}