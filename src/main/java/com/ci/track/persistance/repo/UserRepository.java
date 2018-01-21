/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ci.track.persistance.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ci.track.persistance.domain.User;

/**
 *
 * @author rkarim
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findByUserName(String userName);
    User findById(String id);
}
