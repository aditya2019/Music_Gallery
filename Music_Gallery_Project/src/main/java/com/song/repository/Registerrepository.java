package com.song.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.register.Register;



public interface Registerrepository extends MongoRepository<Register, String> {
   public Register findOneByEmail(String email);
    public Register findOneByPassword(String password);

}
