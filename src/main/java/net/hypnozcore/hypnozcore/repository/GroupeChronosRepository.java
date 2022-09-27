package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.GroupeChronos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeChronosRepository extends JpaRepository<GroupeChronos, GroupeChronos.GroupeChronosPK>, JpaSpecificationExecutor<GroupeChronos> {
}