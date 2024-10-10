package com.example.findByName;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NurseController {
	
	private ArrayList<Nurse> nurses;
	//ArrayList
	
	// Constructor to initialize the list of nurses with data
	public NurseController() {
		nurses = new ArrayList<>();
		nurses.add(new Nurse("Alberto", "password1"));
		nurses.add(new Nurse("Maria", "password2"));
		nurses.add(new Nurse("Juan", "password3"));
	}
	
	@GetMapping("/findName/{name}")
	public ResponseEntity<Nurse>findByName(@PathVariable String name){
		
		for(Nurse nurse : nurses) {
			if(name.equalsIgnoreCase(nurse.user())) {
				System.out.println(nurse);
				return ResponseEntity.ok(nurse);
			}		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	
		
		
	}
	

}
