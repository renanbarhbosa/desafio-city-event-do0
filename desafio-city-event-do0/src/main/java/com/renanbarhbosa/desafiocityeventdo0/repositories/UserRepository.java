package com.renanbarhbosa.desafiocityeventdo0.repositories;

import com.renanbarhbosa.desafiocityeventdo0.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
