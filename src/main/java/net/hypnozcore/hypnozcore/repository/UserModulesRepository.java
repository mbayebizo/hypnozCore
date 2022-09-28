package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Modules;
import net.hypnozcore.hypnozcore.models.UserModules;
import net.hypnozcore.hypnozcore.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserModulesRepository extends JpaRepository<UserModules, UserModules.UserModulesPK>, JpaSpecificationExecutor<UserModules> {
    List<UserModules> findByIdModulesIdAndIdUsersIdOrderByModulesCodeAsc(Long modulesId, Long usersId);

    List<UserModules> findByIdModulesId(Long modulesId);

    Optional<UserModules> findByIdModulesIdAndIdUsersId(Long modulesId, Long usersId);

    @Transactional
    @Modifying
    @Query("delete from UserModules u where u.modules = ?1 and u.users = ?2")
    void deleteByModulesAndUsers(Modules modules, Users users);
}