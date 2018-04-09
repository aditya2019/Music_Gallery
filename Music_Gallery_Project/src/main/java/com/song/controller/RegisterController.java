package com.song.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.Criteria;
import com.register.Register;
import com.song.configue.MongoDBConfigure;
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
	public ResponseEntity<Void> create(@Valid @RequestBody Register register , BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
			System.out.println("somethis is wrong");
			bindingResult
			.getFieldErrors()
			.stream()
			.forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
		}else {
			registerrepository.save(register);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.accepted().build();
	}
	

	@RequestMapping(value = "/verify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> login(@RequestBody Register register) {
		Map<String, String> response = new HashMap<String, String>();
		String email = String.valueOf(register.getEmail());
		String password = String.valueOf(register.getPassword());
		// String type = String.valueOf(register.getType());

if ((registerrepository.findOneByEmail(email) != null)
				&& (registerrepository.findOneByPassword(password) != null)) {
			String test=String.valueOf(registerrepository.findRegisterByEmail(register.getEmail()));
			response.put("ok",test );
			System.out.println(registerrepository.findRegisterByEmail(register.getEmail()));
			return ResponseEntity.accepted().body(response);

		} else {
			if ((registerrepository.findOneByEmail(email) != null)) {
				response.put("error", " !Opss     -WRONG PASSWORD");
				return ResponseEntity.badRequest().body(response);
			} else if ((registerrepository.findOneByPassword(password) != null)) {
				response.put("error", " !Opss    -WRONG EMAIL");
				return ResponseEntity.badRequest().body(response);
			} else {
				response.put("error", " !Opss    -Both Email AND Password Wrong");
				return ResponseEntity.badRequest().body(response);
			}
		}
	}

}
