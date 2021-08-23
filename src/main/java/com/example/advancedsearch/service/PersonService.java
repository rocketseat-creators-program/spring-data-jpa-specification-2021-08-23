package com.example.advancedsearch.service;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import com.example.advancedsearch.specification.PersonSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private PersonSpecification personSpecification;

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    public Page<Person> findAll(PersonFilter filter, Pageable pageable) {
        return this.personRepository.findAll(this.personSpecification.persons(filter), pageable);
    }

}
