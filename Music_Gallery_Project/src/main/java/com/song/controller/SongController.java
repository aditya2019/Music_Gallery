package com.song.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.song.repository.Songrepository;
import com.songlist.Song;


@RestController
@RequestMapping("/musicguru")
public class SongController {
     
	private Songrepository songrepository;
	public SongController(Songrepository songrepository) {
        this.songrepository = songrepository;
    }
	@GetMapping("/all")
    public List<Song> getAll() {
        return songrepository.findAll();
    }
	@RequestMapping(value = "/songs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody Song song) {
		 try {
			 songrepository.save(song);
		  return ResponseEntity.noContent().build();
		 } catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.CONFLICT).build();
		 }
		}
	
}
