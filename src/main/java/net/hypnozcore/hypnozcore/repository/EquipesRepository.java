package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Equipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipesRepository extends JpaRepository<Equipes, Integer>, JpaSpecificationExecutor<Equipes> {
}