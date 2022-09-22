package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserModules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserModulesRepository extends JpaRepository<UserModules, UserModules.UserModulesPK>, JpaSpecificationExecutor<UserModules> {
    List<UserModules> findById_ModulesIdAndId_UsersIdOrderByModules_CodeAsc(Long modulesId, Long usersId);
}