package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.TiersAppreciations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TiersAppreciationsRepository extends JpaRepository<TiersAppreciations, String>, JpaSpecificationExecutor<TiersAppreciations> {
}