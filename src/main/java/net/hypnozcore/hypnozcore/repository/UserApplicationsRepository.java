package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserApplicationsRepository extends JpaRepository<UserApplications, UserApplications.UserApplicationsPK>, JpaSpecificationExecutor<UserApplications> {
    List<UserApplications> findByIdUsersIdAndApplicationsModulesId(Long usersId, Long modulesId);
}