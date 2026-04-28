package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.mapper.PersonMapper;
import com.example.nexustechuniversity.repository.PersonRepository;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDto getPersonId(Long id) {
        return PersonMapper.INSTANCE.toPersonDto( personRepository.findById(id).orElse(null));
    }

    @Override
    public PersonDto createPerson(PersonDto person) {

        return PersonMapper.INSTANCE.toPersonDto( personRepository.save(PersonMapper.INSTANCE.toPerson(person)));

    }

    @Override
    public PersonDto update(PersonDto person) {
        return PersonMapper.INSTANCE.toPersonDto( personRepository.save(PersonMapper.INSTANCE.toPerson(person)));
    }
}
