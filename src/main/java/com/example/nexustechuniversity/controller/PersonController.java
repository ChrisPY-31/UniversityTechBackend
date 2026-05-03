package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("permitAll()")
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

    @PreAuthorize("permitAll()")
    @PutMapping("person/{idPerson}")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto , @PathVariable  long idPerson){

        if(personService.existPerson(idPerson) && personDto != null){
            return ResponseEntity.ok().body(personService.updatePerson(personDto));
        }
        return ResponseEntity.notFound().build();
    }
}
