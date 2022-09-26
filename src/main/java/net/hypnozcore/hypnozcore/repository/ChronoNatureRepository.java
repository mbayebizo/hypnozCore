package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.ChronoNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChronoNatureRepository extends JpaRepository<ChronoNature, Integer>, JpaSpecificationExecutor<ChronoNature> {
}