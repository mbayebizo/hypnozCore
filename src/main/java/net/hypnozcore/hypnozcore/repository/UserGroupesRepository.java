package net.hypnozcore.hypnozcore.repository;

import net.hypnozcore.hypnozcore.models.UserGroupes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserGroupesRepository extends JpaRepository<UserGroupes, UserGroupes.UserGroupesPK>, JpaSpecificationExecutor<UserGroupes> {
    List<UserGroupes> findById_GroupesId(Long groupesId);

    long removeById_UsersIdAllIgnoreCase(Long usersId);



}