package com.example.advancedsearch.service;

import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

}
