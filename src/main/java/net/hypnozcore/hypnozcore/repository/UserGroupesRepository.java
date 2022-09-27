package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserGroupes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupesRepository extends JpaRepository<UserGroupes, UserGroupes.UserGroupesPK>, JpaSpecificationExecutor<UserGroupes> {
    List<UserGroupes> findByIdGroupesId(Long groupesId);

    long removeByIdUsersIdAllIgnoreCase(Long usersId);



}