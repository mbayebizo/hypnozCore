package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Fonctions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionsRepository extends JpaRepository<Fonctions, Long>, JpaSpecificationExecutor<Fonctions> {
}