package com.alifetvaci.springdatajpaexample.user.repository;

import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);

}
