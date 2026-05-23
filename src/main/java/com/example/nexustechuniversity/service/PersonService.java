package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.ChangePasswordRequest;
import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Dto.UserResponse;
import com.example.nexustechuniversity.Model.Person;
import com.example.nexustechuniversity.Model.User;
import com.example.nexustechuniversity.mapper.CourseResponseMapper;
import com.example.nexustechuniversity.mapper.PersonMapper;
import com.example.nexustechuniversity.repository.CursoRepository;
import com.example.nexustechuniversity.repository.PersonRepository;
import com.example.nexustechuniversity.repository.UserRepository;
import com.example.nexustechuniversity.service.Impl.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Page<PersonDto> getPersons(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("idPerson"));
        return personRepository.findAll(page).map(PersonMapper.INSTANCE::toPersonDto);
    }

    @Override
    public PersonDto getPersonId(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) return null;
        PersonDto dto = PersonMapper.INSTANCE.toPersonDto(person);
        dto.setCourses(
            cursoRepository.findByInstructor_IdPerson(id, Pageable.unpaged())
                .stream()
                .map(CourseResponseMapper.INSTANCE::toCourseResponseDto)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @Override
    public PersonDto createPerson(PersonDto person) {
        return PersonMapper.INSTANCE.toPersonDto(personRepository.save(PersonMapper.INSTANCE.toPerson(person)));
    }

    @Override
    public PersonDto updatePerson(UserResponse request, long idPerson) {
        Person person = personRepository.findById(idPerson)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada: " + idPerson));

        person.setName(request.name());
        person.setLastName(request.lastName());
        personRepository.save(person);

        userRepository.findByPerson_IdPerson(idPerson).ifPresent(user -> {
            if (request.email() != null) user.setEmail(request.email());
            userRepository.save(user);
        });

        PersonDto dto = PersonMapper.INSTANCE.toPersonDto(person);
        dto.setCourses(
            cursoRepository.findByInstructor_IdPerson(idPerson, Pageable.unpaged())
                .stream()
                .map(CourseResponseMapper.INSTANCE::toCourseResponseDto)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @Override
    public boolean existPerson(long idPerson) {
        return personRepository.existsPersonByIdPerson(idPerson);
    }

    @Override
    public UserResponse getPersonProfile(Long personId) {
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null) return null;
        User user = userRepository.findByPerson_IdPerson(personId).orElse(null);
        if (user == null) return null;
        return new UserResponse(person.getIdPerson(), person.getName(), person.getLastName(), user.getEmail(), user.getPassword());
    }

    @Override
    public boolean updatePassword(Long personId, ChangePasswordRequest request) {
        return userRepository.findByPerson_IdPerson(personId).map(user -> {
            user.setPassword(passwordEncoder.encode(request.newPassword()));
            userRepository.save(user);
            return true;
        }).orElse(false);
    }

    @Override
    public void deletePerson(long idPerson) {
        User user = userRepository.findById(idPerson)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        userRepository.delete(user);
    }

    @Override
    public void deleteUser(long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + idUser));
        userRepository.delete(user);
    }

}
