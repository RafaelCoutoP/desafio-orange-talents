package com.rafaelcdev.desafioorange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaelcdev.desafioorange.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
