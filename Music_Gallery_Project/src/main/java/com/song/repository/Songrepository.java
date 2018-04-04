package com.song.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.songlist.Song;

public interface Songrepository extends MongoRepository<Song, Integer> {

}
