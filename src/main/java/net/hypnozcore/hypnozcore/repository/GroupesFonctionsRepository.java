package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Fonctions;
import net.hypnozcore.hypnozcore.models.Groupes;
import net.hypnozcore.hypnozcore.models.GroupesFonctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface GroupesFonctionsRepository extends JpaRepository<GroupesFonctions, GroupesFonctions.GroupesFonctionsPK>, JpaSpecificationExecutor<GroupesFonctions> {
    Optional<GroupesFonctions> findByIdGroupesIdAndIdFonctionsId(Long groupesId, Long fonctionsId);

    @Modifying
    @Transactional
    @Query("delete from GroupesFonctions g where g.fonctions = ?1 and g.groupes = ?2")
    void deleteByFonctionsAndGroupes(Fonctions fonctions, Groupes groupes);

}