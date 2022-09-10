package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.GroupesModules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupesModulesRepository extends JpaRepository<GroupesModules, GroupesModules.GroupesModulesPK>, JpaSpecificationExecutor<GroupesModules> {
}