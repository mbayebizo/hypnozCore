package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Long>, JpaSpecificationExecutor<Modules> {
}