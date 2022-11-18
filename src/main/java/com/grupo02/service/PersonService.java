package com.grupo02.service;

import com.grupo02.dto.PersonDto;
import com.grupo02.dto.jpa.PersonJpa;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class PersonService {

  PersonJpaRepository repository;

  public List<PersonJpa> getAllPerson() {
    Iterable<PersonJpa> allPerson = repository.findAll();
    List<PersonJpa> response = new ArrayList<>();
    allPerson.forEach(response::add);

    return response;
  }

  public long savePerson(PersonDto personDto) {
    PersonJpa personJpa = PersonJpa.builder().nombre(personDto.getNombre()).apellido(personDto.getApellido())
        .telefono(personDto.getTelefono()).build();

    return repository.save(personJpa).getId();
  }
}
