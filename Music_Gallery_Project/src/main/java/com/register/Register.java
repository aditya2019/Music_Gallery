package com.register;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Register implements Serializable{
	@NotNull
    @Size(min=2, max=20)
	private String name;
	@NotNull
	@Email
//	@Pattern(regexp = "^([a-z][A-Z])$")
	private String email;
	private String password;
	private String type="user";
	
	 public Register() {
	    	super();
	    }
	 public Register(String name , String email , String password) {    
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

@Override
	public String toString() {
		return type;
	}


}
