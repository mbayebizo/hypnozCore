package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long>, JpaSpecificationExecutor<Applications> {
    Optional<Applications> findByCodeAndModule(String code, String module);
}