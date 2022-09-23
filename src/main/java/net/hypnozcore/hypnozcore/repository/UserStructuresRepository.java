package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserStructures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStructuresRepository extends JpaRepository<UserStructures, UserStructures.UserStructuresPK>, JpaSpecificationExecutor<UserStructures> {
    long deleteByIdUsersIdAllIgnoreCase(Long usersId);
    List<UserStructures> findByIdStructuresId(Long structuresId);
}