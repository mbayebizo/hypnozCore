package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserModules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModulesRepository extends JpaRepository<UserModules, UserModules.UserModulesPK>, JpaSpecificationExecutor<UserModules> {
}