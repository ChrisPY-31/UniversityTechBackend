package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("person/{id}")
    public ResponseEntity<PersonDto> getPersonId(@PathVariable long id){
        Optional<PersonDto> person = Optional.ofNullable(personService.getPersonId(id));
        return person.map(ResponseEntity::ok)
                .orElseThrow();
    }

    @PostMapping("person")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDto));
    }
}
