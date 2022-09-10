package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Espion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EspionRepository extends JpaRepository<Espion, Long>, JpaSpecificationExecutor<Espion> {
}