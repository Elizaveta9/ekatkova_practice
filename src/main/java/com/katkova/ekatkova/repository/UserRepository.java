package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByLogin(String login);
}
