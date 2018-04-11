package com.mymusic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.songlist.Song;


@Document(collection ="test2")
public class Mymusic {
	
	@Id
	private String id;
	
	@DBRef 
	private Song test;
	
	public Mymusic()
	{
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Song getTest() {
		return test;
	}

	public void setTest(Song test) {
		this.test = test;
	}
	
}
