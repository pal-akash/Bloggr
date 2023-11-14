package com.akash.bloggr.repositories;


import com.akash.bloggr.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
