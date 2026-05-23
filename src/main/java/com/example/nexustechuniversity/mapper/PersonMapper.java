package com.example.nexustechuniversity.mapper;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toPerson(PersonDto personDto);

    @Mapping(target = "courses", ignore = true)
    PersonDto toPersonDto(Person person);
}
