package com.song.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.register.Register;
import com.song.repository.Registerrepository;


@RestController
@RequestMapping("/userlog")
public class RegisterController {
   
	
	@Autowired
	private Registerrepository registerrepository;

    public RegisterController(Registerrepository registerrepository) {
        this.registerrepository = registerrepository;
    }
	
	
    @RequestMapping(value = "/Userdata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody Register register) {
		 try {
			 registerrepository.save(register);
		  return ResponseEntity.noContent().build();
		 } catch (Exception e) {
		  return ResponseEntity.status(HttpStatus.CONFLICT).build();
		 }
		}
    
    @RequestMapping(value = "/verify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> login(@RequestBody Register register) {
    Map<String, String> response = new HashMap<String, String>();
    String email = String.valueOf(register.getEmail());
    String password = String.valueOf(register.getPassword());

  if ((registerrepository.findOneByEmail(email) != null) && (registerrepository.findOneByPassword(password) != null))
    {
    response.put("ok", "Logedin Succesfuly");
    return ResponseEntity.accepted().body(response);
   
    } else 
    {
    	if ((registerrepository.findOneByEmail(email) != null))
    	{
    response.put("error", " !Opss     -WRONG PASSWORD");
    return ResponseEntity.badRequest().body(response);
    	}
    	else if((registerrepository.findOneByPassword(password) != null))
    	{response.put("error", " !Opss    -WRONG EMAIL");
        return ResponseEntity.badRequest().body(response);
    	}else
    	{
    		response.put("error", " !Opss    -Both Email AND Password Wrong");
            return ResponseEntity.badRequest().body(response);
    	}
  }
 }
	
}
