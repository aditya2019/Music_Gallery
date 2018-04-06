package com.mymusic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Mymusic implements Serializable{
    
	@Id
	 private Integer id;
	 private String song_name;
	 private Integer year;
	 private String singer_name;
	 private String music_director;
	 private String language;
	 private Integer rating;
	 private Integer duration;
	 private String type;
	 private String song_path;
	 
   public Mymusic()
   {
	
   }
   public Mymusic(Integer id,String song_name,Integer year,String singer_name,String music_director,String language,Integer rating,Integer duration,String type,String song_path)
   {
	  this.id = id;
	  this.song_name = song_name;
	  this.year = year;
	  this.singer_name = singer_name;
	  this.music_director = music_director;
	  this.language = language;
	  this.rating = rating;
	  this.duration = duration;
	  this.type = type;
	  this.song_path = song_path;
   }
	 
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	public String getMusic_director() {
		return music_director;
	}
	public void setMusic_director(String music_director) {
		this.music_director = music_director;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSong_path() {
		return song_path;
	}
	public void setSong_path(String song_path) {
		this.song_path = song_path;
	}
	
}
