package com.example.nexustechuniversity.Dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idPerson", "name", "lastName", "email", "password"})
public record UserResponse(long idPerson, String name, String lastName, String email, String password) {

}
