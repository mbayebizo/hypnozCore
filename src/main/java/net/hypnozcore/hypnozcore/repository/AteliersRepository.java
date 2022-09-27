package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Ateliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AteliersRepository extends JpaRepository<Ateliers, String>, JpaSpecificationExecutor<Ateliers> {
}