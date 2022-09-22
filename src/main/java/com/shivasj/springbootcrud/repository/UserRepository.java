package com.shivasj.springbootcrud.repository;

import com.shivasj.springbootcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

}
