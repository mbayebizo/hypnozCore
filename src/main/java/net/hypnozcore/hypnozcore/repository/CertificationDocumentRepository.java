package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.CertificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationDocumentRepository extends JpaRepository<CertificationDocument, Long>, JpaSpecificationExecutor<CertificationDocument> {
}