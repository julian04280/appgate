package com.addgate.calculator.repository;

import com.addgate.calculator.repository.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataLoginRepository extends JpaRepository<LoginEntity, Long> {

    LoginEntity findByEmailAndPassword(String email, String password);
}
