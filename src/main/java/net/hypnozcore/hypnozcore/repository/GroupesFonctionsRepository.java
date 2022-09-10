package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.GroupesFonctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupesFonctionsRepository extends JpaRepository<GroupesFonctions, GroupesFonctions.GroupesFonctionsPK>, JpaSpecificationExecutor<GroupesFonctions> {
}