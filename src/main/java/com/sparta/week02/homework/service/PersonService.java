package com.sparta.week02.homework.service;

import com.sparta.week02.homework.domain.Person;
import com.sparta.week02.homework.domain.PersonRepository;
import com.sparta.week02.homework.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long updatePerson(Long id, PersonRequestDto personRequestDto) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new NullPointerException("ID가 존재하지 않습니다.")
        );

        person.updatePerson(personRequestDto);
        return person.getId();
    }
}
