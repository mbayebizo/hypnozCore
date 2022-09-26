package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Banques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BanquesRepository extends JpaRepository<Banques, String>, JpaSpecificationExecutor<Banques> {
}