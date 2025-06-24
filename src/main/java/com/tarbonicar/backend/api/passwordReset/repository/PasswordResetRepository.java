package com.tarbonicar.backend.api.passwordReset.repository;

import com.tarbonicar.backend.api.passwordReset.entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {

    Optional<PasswordReset> findByCode(String code);
}
