package com.groupproject.telecomproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.groupproject.telecomproject.entity.Users;
import com.groupproject.telecomproject.service.UsersService;

@EnableGlobalMethodSecurity(jsr250Enabled = false, prePostEnabled = true, securedEnabled = false)
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UsersRestController {

  @Autowired
  UsersService userService;
    
  @GetMapping("/{username}")
  public ResponseEntity<Users> findById(@PathVariable("username") String username){
	  
	  try {
		  Users users = userService.findByUsername(username);
		  if(users == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<Users>(users, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

  @PostMapping("/signup")
  public ResponseEntity<Users> createUser(@RequestBody Users user) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    try {
      Users _user = userService
          .add(new Users(user.getFirstName(), user.getLastName(), user.getUsername(), encoder.encode(user.getPass())));
      return new ResponseEntity<>(_user, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Users> updateUser(@PathVariable("id") int id, @RequestBody Users user) {
    Users userData = userService.findById(id);
    if (userData != null) {
      userData.setFirstName(user.getFirstName());
	  userData.setLastName(user.getLastName());
	  userData.setUsername(user.getUsername());
      userData.setUsername(user.getPass());
      return new ResponseEntity<>(userService.add(userData), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
    try {
      userService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  

  
  
}
