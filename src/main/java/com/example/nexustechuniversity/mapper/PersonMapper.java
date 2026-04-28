package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toPerson(PersonDto personDto);

    PersonDto toPersonDto(Person person);
}
