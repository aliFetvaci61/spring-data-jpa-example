package com.alifetvaci.springdatajpaexample.token.repository;

import com.alifetvaci.springdatajpaexample.token.model.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
}
