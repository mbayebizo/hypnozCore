package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Structures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StructuresRepository extends JpaRepository<Structures, Long>, JpaSpecificationExecutor<Structures> {
}