package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.ChangePasswordRequest;
import com.example.nexustechuniversity.Dto.PersonDto;
import com.example.nexustechuniversity.Dto.UserResponse;
import org.springframework.data.domain.Page;

public interface IPersonService {

    Page<PersonDto> getPersons(int pageNumber , int pageSize);

    PersonDto getPersonId(Long id);

    PersonDto createPerson(PersonDto person);

    PersonDto updatePerson(UserResponse request, long idPerson);

    boolean existPerson(long idPerson);

    UserResponse getPersonProfile(Long personId);

    boolean updatePassword(Long personId, ChangePasswordRequest request);

    void deletePerson(long idPerson);

    void deleteUser(long idUser);

}
