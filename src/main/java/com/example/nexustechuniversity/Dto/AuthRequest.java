package com.example.nexustechuniversity.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


public record AuthRequest(@NonNull
						  @NotBlank String username ,
						  @NotNull @Max(8) String password) {

	
}
