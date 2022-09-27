package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Activites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitesRepository extends JpaRepository<Activites, Long>, JpaSpecificationExecutor<Activites> {
}