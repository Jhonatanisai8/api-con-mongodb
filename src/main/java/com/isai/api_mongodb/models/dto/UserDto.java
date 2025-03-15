package com.isai.api_mongodb.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String imagePath;
    private String firstName;
    private String lastName;
    private String departamento;
}
