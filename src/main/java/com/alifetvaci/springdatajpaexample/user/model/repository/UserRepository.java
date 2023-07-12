package com.alifetvaci.springdatajpaexample.user.model.repository;

import com.alifetvaci.springdatajpaexample.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
