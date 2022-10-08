package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.Sites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SitesRepository extends JpaRepository<Sites, Long>, JpaSpecificationExecutor<Sites> {
	List<Sites> findByStructuresId(Long id);
}