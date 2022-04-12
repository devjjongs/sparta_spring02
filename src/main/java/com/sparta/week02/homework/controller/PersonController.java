package com.sparta.week02.homework.controller;

import com.sparta.week02.homework.domain.Person;
import com.sparta.week02.homework.domain.PersonRepository;
import com.sparta.week02.homework.domain.PersonRequestDto;
import com.sparta.week02.homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    // 생성
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto personRequestDto) {
        Person person = new Person(personRequestDto);
        return personRepository.save(person);
    }

    // 조회
    @GetMapping("/api/persons")
    public List<Person> getPerson() {
        return personRepository.findAll();
    }

    // 변경
    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto) {
        return personService.updatePerson(id, personRequestDto);
    }

    // 삭제
    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }

}
