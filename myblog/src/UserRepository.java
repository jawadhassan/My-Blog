package com.example.myblog.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.myblog.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{

	public Optional<User> findUserByEmail(String email);
}
