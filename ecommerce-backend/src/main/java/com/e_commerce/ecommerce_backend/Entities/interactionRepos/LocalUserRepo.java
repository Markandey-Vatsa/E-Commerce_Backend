package com.e_commerce.ecommerce_backend.Entities.interactionRepos;

import com.e_commerce.ecommerce_backend.Entities.Localuser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalUserRepo extends JpaRepository<Localuser,Long> {
    Optional<Localuser> findByUsernameIgnoreCase(String username);

    Optional<Localuser> findByEmailIgnoreCase(String email);

}
