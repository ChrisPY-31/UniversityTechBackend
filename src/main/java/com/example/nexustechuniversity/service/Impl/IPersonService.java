package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.PersonDto;

public interface IPersonService {

    PersonDto createPerson(PersonDto person);

    PersonDto update(PersonDto person);

}
