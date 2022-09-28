package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.UserFonctions;
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
public interface UserFonctionsRepository extends JpaRepository<UserFonctions, UserFonctions.UserFonctionsPK>, JpaSpecificationExecutor<UserFonctions> {
    @Query("select u from UserFonctions u where u.id.fonctionsId = ?1")
    List<UserFonctions> findByIdFonctionsId(Long fonctionsId);
    Optional<UserFonctions> findByIdFonctionsIdAndIdUsersId(Long fonctionsId, Long usersId);

    @Transactional
    @Modifying
    @Query("delete from UserFonctions u where u.fonctions = ?1 and u.users = ?2")
    void deleteByFonctionsAndUsers(Fonctions fonctions, Users users);

    List<UserFonctions> findByIdUsersIdAndFonctionsApplicationsId(Long usersId, Long applicationsId);

    List<UserFonctions> findByFonctionsApplicationsId(Long applicationsId);
}