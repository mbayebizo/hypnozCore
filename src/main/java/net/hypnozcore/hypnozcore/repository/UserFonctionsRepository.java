package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserFonctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFonctionsRepository extends JpaRepository<UserFonctions, UserFonctions.UserFonctionsPK>, JpaSpecificationExecutor<UserFonctions> {
    List<UserFonctions> findByIdFonctionsIdAndIdUsersId(Long fonctionsId, Long usersId);

    List<UserFonctions> findByIdUsersIdAndFonctionsApplicationsId(Long usersId, Long applicationsId);

    List<UserFonctions> findByFonctionsApplicationsId(Long applicationsId);
}