package com.song.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mymusic.Mymusic;

public interface Mymusicrepository extends MongoRepository<Mymusic, Integer>{

	//public Object findMymusicByObjectId();
}
