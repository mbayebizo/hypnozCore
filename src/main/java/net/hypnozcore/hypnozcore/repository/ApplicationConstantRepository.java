package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.ApplicationConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationConstantRepository extends JpaRepository<ApplicationConstant, String>, JpaSpecificationExecutor<ApplicationConstant> {
}