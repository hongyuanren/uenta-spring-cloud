package com.uenta.cloud.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uenta.cloud.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}