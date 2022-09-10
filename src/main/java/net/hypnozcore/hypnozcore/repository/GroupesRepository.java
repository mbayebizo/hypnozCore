package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Groupes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupesRepository extends JpaRepository<Groupes, Long>, JpaSpecificationExecutor<Groupes> {
}