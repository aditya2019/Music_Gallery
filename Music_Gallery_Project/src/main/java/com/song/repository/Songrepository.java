package com.song.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.register.Register;
import com.songlist.Song;

public interface Songrepository extends MongoRepository<Song, Integer> {
	public Register findSongByName(String name);

}
