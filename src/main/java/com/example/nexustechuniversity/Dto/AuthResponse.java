package com.example.nexustechuniversity.Dto;

import com.example.nexustechuniversity.utilities.Role;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"idUser, role ,message" , "status" , "accoundLocked"})
public record AuthResponse(long idUser, Role role, String message , boolean status , boolean accoundLocked ) {
}
