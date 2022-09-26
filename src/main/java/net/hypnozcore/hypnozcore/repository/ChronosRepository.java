package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Chronos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChronosRepository extends JpaRepository<Chronos, Long>, JpaSpecificationExecutor<Chronos> {
}