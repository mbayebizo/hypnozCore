package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.UserApplications;
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
public interface UserApplicationsRepository extends JpaRepository<UserApplications, UserApplications.UserApplicationsPK>, JpaSpecificationExecutor<UserApplications> {
    Optional<UserApplications> findByIdApplicationsIdAndIdUsersId(Long applicationsId, Long usersId);

    @Transactional
    @Modifying
    @Query("delete from UserApplications u where u.applications = ?1 and u.users = ?2")
    void deleteByApplicationsAndUsers(Applications applications, Users users);
    List<UserApplications> findByIdUsersIdAndApplicationsModulesId(Long usersId, Long modulesId);

    List<UserApplications> findByIdApplicationsId(Long applicationsId);


}