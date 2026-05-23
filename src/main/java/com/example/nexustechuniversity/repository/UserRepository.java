package com.example.nexustechuniversity.repository;

import java.util.Optional;

import com.example.nexustechuniversity.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nexustechuniversity.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);

	Optional<User> findByPerson_IdPerson(Long personId);

}
