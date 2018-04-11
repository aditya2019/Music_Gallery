package com.song.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mymusic.Mymusic;
import com.register.Register;
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
//			 MongoClient client = new MongoClient("localhost", 27017);
//				MongoDatabase database = client.getDatabase("musicgallery");
//				MongoCollection<org.bson.Document> collection = database.getCollection("song");
//		 
//				List<Document> documents = (List<Document>) collection.find().into(
//						new ArrayList<Document>());
//		 
//		               for(Document document : documents){
//		                   System.out.println(document);
//		               }
			 String test=String.valueOf(songrepository.findSongByName(song.getName()));
				//response.put("ok",test );
				System.out.println(songrepository.findSongByName(song.getName()));
//			
		  return ResponseEntity.noContent().build();
		  
		 // System.out.println(songrepository.findSongBySong_name(song.getSong_name());
		 } catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.CONFLICT).build();
		 }
		}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> log (@RequestBody Song song) {
		 
			 String test=String.valueOf(songrepository.findSongByName(song.getName()));
				//response.put("ok",test );
				System.out.println(songrepository.findSongByName(song.getName()));
//			
		  return ResponseEntity.noContent().build();
		 
		}
	
}
