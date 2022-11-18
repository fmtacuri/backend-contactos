package com.grupo02.service;

import com.grupo02.dto.jpa.PersonJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends CrudRepository<PersonJpa, Long> {

}
