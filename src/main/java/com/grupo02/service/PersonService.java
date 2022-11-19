package com.grupo02.service;

import com.grupo02.dto.PersonDto;
import com.grupo02.dto.jpa.PersonJpa;
import com.grupo02.dto.jpa.PersonJpa.PersonJpaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

  public PersonJpa savePerson(PersonDto personDto) {
    PersonJpaBuilder builder = PersonJpa.builder();
    builder.nombre(personDto.getNombre());
    builder.apellido(personDto.getApellido());
    builder.telefono(personDto.getTelefono());

    if (!Objects.isNull(personDto.getId())) {
      builder.id(personDto.getId());
    }
    return repository.save(builder.build());
  }

  public void deletePerson(long id) {
    repository.deleteById(id);
  }
}
