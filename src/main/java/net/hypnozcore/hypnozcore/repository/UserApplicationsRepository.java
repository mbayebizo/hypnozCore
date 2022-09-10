package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationsRepository extends JpaRepository<UserApplications, UserApplications.UserApplicationsPK>, JpaSpecificationExecutor<UserApplications> {
}