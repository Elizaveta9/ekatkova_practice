package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    UserEntity findByLogin(String login);

    UserEntity findByLoginAndPassword(String login, String password);

    Boolean existsByLogin(String login);

    Boolean existsByLoginAndPassword(String login, String password);
}
