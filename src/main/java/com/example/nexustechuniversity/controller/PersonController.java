package com.example.nexustechuniversity.controller;

import com.example.nexustechuniversity.Dto.ChangePasswordRequest;
import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Dto.UserResponse;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.data.domain.Page;
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("persons")
    public ResponseEntity<Page<PersonDto>> persons(@RequestParam(defaultValue = "0") int pageNumber , @RequestParam(defaultValue = "10") int pageSize){
                Page<PersonDto> pageUsers = personService.getPersons(pageNumber , pageSize);
        return ResponseEntity.ok().body(pageUsers);
    }

    @PreAuthorize("isAuthenticated()")
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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("person/{id}/profile")
    public ResponseEntity<UserResponse> getPersonProfile(@PathVariable long id) {
        UserResponse profile = personService.getPersonProfile(id);
        if (profile == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(profile);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("person/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable long id, @RequestBody ChangePasswordRequest request) {
        if (!personService.updatePassword(id, request)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("person/{idPerson}")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody UserResponse personDto , @PathVariable  long idPerson){

        if(personService.existPerson(idPerson) && personDto != null){
            return ResponseEntity.ok().body(personService.updatePerson(personDto, idPerson));
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        personService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
