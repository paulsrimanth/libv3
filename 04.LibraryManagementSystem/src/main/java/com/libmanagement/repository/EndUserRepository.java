package com.libmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libmanagement.model.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser,Integer>
{
	Optional<EndUser>findByEmail(String email);
}
