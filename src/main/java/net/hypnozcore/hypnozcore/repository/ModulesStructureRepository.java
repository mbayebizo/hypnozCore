package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.ModulesStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesStructureRepository extends JpaRepository<ModulesStructure, ModulesStructure.ModulesStructurePK>, JpaSpecificationExecutor<ModulesStructure> {
}