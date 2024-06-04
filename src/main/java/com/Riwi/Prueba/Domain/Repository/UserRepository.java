package com.Riwi.Prueba.Domain.Repository;

import com.Riwi.Prueba.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
