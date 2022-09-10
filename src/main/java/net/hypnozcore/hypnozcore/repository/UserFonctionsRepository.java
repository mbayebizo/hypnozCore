package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserFonctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFonctionsRepository extends JpaRepository<UserFonctions, UserFonctions.UserFonctionsPK>, JpaSpecificationExecutor<UserFonctions> {
}