package com.hcl.phonepaytransaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.phonepaytransaction.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
