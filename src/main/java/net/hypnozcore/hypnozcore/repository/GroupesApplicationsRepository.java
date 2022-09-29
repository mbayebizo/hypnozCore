package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Applications;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupesApplicationsRepository extends JpaRepository<GroupesApplications, GroupesApplications.GroupesApplicationsPK>, JpaSpecificationExecutor<GroupesApplications> {
    Optional<GroupesApplications> findByIdApplicationsIdAndIdGroupesId(Long applicationsId, Long groupesId);

    void deleteByApplicationsAndGroupes(Applications applications, Groupes groupes);
}