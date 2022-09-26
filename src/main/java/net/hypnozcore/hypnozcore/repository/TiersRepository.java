package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long>, JpaSpecificationExecutor<Tiers> {
}