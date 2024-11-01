package com.example.sathish.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.sathish.modules.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByAadhar(String aadhar);

}
