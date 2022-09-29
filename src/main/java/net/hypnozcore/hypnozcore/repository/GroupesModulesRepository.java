package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesModules;
import net.hypnozcore.hypnozcore.models.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface GroupesModulesRepository extends JpaRepository<GroupesModules, GroupesModules.GroupesModulesPK>, JpaSpecificationExecutor<GroupesModules> {
    Optional<GroupesModules> findByIdModulesIdAndIdGroupesId(Long modulesId, Long groupesId);

    @Transactional
    @Modifying
    @Query("delete from GroupesModules g where g.modules = ?1 and g.groupes = ?2")
    void deleteByModulesAndGroupes(Modules modules, Groupes groupes);

}