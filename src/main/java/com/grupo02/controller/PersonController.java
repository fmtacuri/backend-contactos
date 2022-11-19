package com.grupo02.controller;

import com.grupo02.dto.PersonDto;
import com.grupo02.service.PersonService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonController {

  PersonService personService;

  @GetMapping("/all")
  @CrossOrigin
  ResponseEntity<Object> getAllRegister() {
    return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
  }

  @PostMapping()
  @CrossOrigin
  ResponseEntity<Object> savePerson(@RequestBody PersonDto personDto) {
    return new ResponseEntity<>(personService.savePerson(personDto), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin
  ResponseEntity<Object> deletePerso(@PathVariable long id) {
    personService.deletePerson(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping
  @CrossOrigin
  ResponseEntity<Object> updatePerso(@RequestBody PersonDto personDto) {
    return new ResponseEntity<>(personService.savePerson(personDto), HttpStatus.CREATED);
  }
}
