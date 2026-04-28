package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Model.Person;

public interface IPersonService {

    PersonDto getPersonId(Long id);

    PersonDto createPerson(PersonDto person);

    PersonDto update(PersonDto person);

}
